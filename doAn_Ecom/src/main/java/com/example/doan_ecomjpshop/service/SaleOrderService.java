package com.example.doan_ecomjpshop.service;

import com.example.doan_ecomjpshop.entity.SaleOrder;
import com.example.doan_ecomjpshop.entity.SaleOrderDetails;
import com.example.doan_ecomjpshop.exception.NotFoundException;
import com.example.doan_ecomjpshop.repository.SaleOrderDetailsRepository;
import com.example.doan_ecomjpshop.repository.SaleOrderRepository;
import com.example.doan_ecomjpshop.request.UpsertSaleOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SaleOrderService {
    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired
    private SaleOrderDetailsRepository saleOrderDetailsRepository;

    public List<SaleOrder> getSaleOrders() {
        return saleOrderRepository.findAll();
    }


    public SaleOrder getSaleOrderById(Integer id) {
        return saleOrderRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + id);
        });
    }

    public SaleOrder createSaleOrder(UpsertSaleOrderRequest request) {
        List<SaleOrderDetails> saleOrderDetails = saleOrderDetailsRepository.findByIdIn(request.getSaleOrderDetailsesID());

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 15;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int j = 0; j < targetStringLength; j++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        SaleOrder saleOrder = SaleOrder.builder()
                .phone(request.getPhone())
                .email(request.getEmail())
                .code(generatedString)
                .status(false)
                .build();

        return saleOrderRepository.save(saleOrder);
    }

    public SaleOrder updateSaleOrder(Integer id, UpsertSaleOrderRequest request) {
        SaleOrder saleOrder = saleOrderRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + id);
        });

        List<SaleOrderDetails> saleOrderDetails = saleOrderDetailsRepository.findByIdIn(request.getSaleOrderDetailsesID());
        saleOrder.setPhone(request.getPhone());
        saleOrder.setEmail(request.getEmail());
        saleOrder.setTotalPrice(request.getTotalPrice());
        saleOrder.setStatus(request.isStatus());

        return saleOrderRepository.save(saleOrder);
    }

    public void deleteSaleOrder(Integer id) {
        SaleOrder saleOrder = saleOrderRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + id);
        });
        saleOrderRepository.delete(saleOrder);
    }
}
