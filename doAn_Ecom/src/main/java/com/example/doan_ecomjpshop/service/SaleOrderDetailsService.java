package com.example.doan_ecomjpshop.service;

import com.example.doan_ecomjpshop.entity.Item;
import com.example.doan_ecomjpshop.entity.SaleOrder;
import com.example.doan_ecomjpshop.entity.SaleOrderDetails;
import com.example.doan_ecomjpshop.exception.NotFoundException;
import com.example.doan_ecomjpshop.repository.ItemRepository;
import com.example.doan_ecomjpshop.repository.SaleOrderDetailsRepository;
import com.example.doan_ecomjpshop.repository.SaleOrderRepository;
import com.example.doan_ecomjpshop.request.UpsertSaleOrderDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderDetailsService {
    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired
    private SaleOrderDetailsRepository saleOrderDetailsRepository;
    @Autowired
    private ItemRepository itemRepository;


    public List<SaleOrderDetails> getSaleOrderDets() {
        return saleOrderDetailsRepository.findAll();
    }


    public SaleOrderDetails getSaleOrderDetById(Integer id) {
        return saleOrderDetailsRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + id);
        });
    }

    public SaleOrderDetails createSaleOrderDet(UpsertSaleOrderDetailsRequest request) {
        SaleOrder saleOrder = saleOrderRepository.findById(request.getSaleOrder()).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + request.getSaleOrder());
        });

        Item item = itemRepository.findById(request.getItem()).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + request.getItem());
        });

        SaleOrderDetails saleOrderDetails = SaleOrderDetails.builder()
                .sales_quantity(request.getSales_quantity())
                .total_price_by_product(request.getTotal_price_by_product())
                .item(item)
                .build();

        return saleOrderDetailsRepository.save(saleOrderDetails);
    }

    public SaleOrderDetails updateSaleOrderDet(Integer id, UpsertSaleOrderDetailsRequest request) {
        SaleOrderDetails saleOrderDetails = saleOrderDetailsRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + id);
        });

        SaleOrder saleOrder = saleOrderRepository.findById(request.getSaleOrder()).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + request.getSaleOrder());
        });

        Item item = itemRepository.findById(request.getItem()).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + request.getItem());
        });

        saleOrderDetails.setSales_quantity(request.getSales_quantity());
        saleOrderDetails.setTotal_price_by_product(request.getTotal_price_by_product());
        saleOrderDetails.setItem(item);

        return saleOrderDetailsRepository.save(saleOrderDetails);
    }

    public void deleteSaleOrderDet(Integer id) {
        SaleOrderDetails saleOrderDetails = saleOrderDetailsRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + id);
        });
        saleOrderDetailsRepository.delete(saleOrderDetails);
    }
}
