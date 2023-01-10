package com.example.doan_ecomjpshop;

import com.example.doan_ecomjpshop.entity.*;
import com.example.doan_ecomjpshop.exception.NotFoundException;
import com.example.doan_ecomjpshop.repository.*;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

@SpringBootTest
public class InitData {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private SaleOrderDetailsRepository saleOrderDetailsRepository;

    @Autowired
    private SaleOrderRepository saleOrderRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Faker faker;

    @Test
    void save_category() {
        for (int i = 0; i < 6; i++) {
            Category category = Category.builder()
                    .name(faker.commerce().department())
                    .build();
            categoryRepository.save(category);
        }
    }

    @Test
    void save_item() {
        Random rd = new Random();

        List<Category> categories = categoryRepository.findAll();

        for (int i = 0; i < 50; i++) {
            // Random 1 category
            Category rdCategory = categories.get(rd.nextInt(categories.size()));

            // Tạo item
            Item item = Item.builder()
                    .name(faker.commerce().productName())
                    .thumbnail(faker.internet().image())
                    .description(faker.lorem().sentence(25))
                    .quantity(rd.nextInt(30))
                    .price(rd.nextInt(500000))
                    .category(rdCategory)
                    .build();

            itemRepository.save(item);
        }
    }

    @Test
    void save_manager (){
        // Tạo user role admin
        for (int i = 0; i < 5; i++) {
            Manager user = Manager.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .password(passwordEncoder.encode("111"))
                    .roles(List.of("USER", "ADMIN"))
                    .build();
            managerRepository.save(user);
        }
        
    }

    @Test
    void save_saleorderFirst () {
        for (int i = 0; i < 8 ; i++) {
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
            String generatedString = buffer.toString().toUpperCase(Locale.ROOT);

            System.out.println(generatedString);
            SaleOrder saleOrder = SaleOrder.builder()
                    .phone(faker.phoneNumber().cellPhone())
                    .email(faker.internet().emailAddress())
                    .code(generatedString)
                    .build();

            saleOrderRepository.save(saleOrder);
        }
    }

    @Test
    void save_saleorderdetails () {
        Random rd = new Random();
        List<Item> items = itemRepository.findAll();
        List<SaleOrder> saleOrders = saleOrderRepository.findAll();

        for (int i = 0; i < 100 ; i++) {
            Item rdItem = items.get(rd.nextInt(items.size()));
            SaleOrder rdSaleOrder = saleOrders.get(rd.nextInt(saleOrders.size()));
            Integer sQuant = rd.nextInt(50);
            SaleOrderDetails saleOrderDetails = SaleOrderDetails.builder()
                    .sales_quantity(sQuant)
                    .total_price_by_product((rdItem.getPrice())*sQuant)
                    .item(rdItem)
                    .saleOrder(rdSaleOrder)
                    .build();
            saleOrderDetailsRepository.save(saleOrderDetails);
        }
    }

    @Test
    void save_saleorderSecond () {
        List<SaleOrderDetails> saleOrderDetails = saleOrderDetailsRepository.findAll();
        for (int i = 1; i < 9 ; i++) {
            int finalI = i;
            SaleOrder saleOrder = saleOrderRepository.findById(i).orElseThrow(() -> {
                throw new NotFoundException("Not found with id = " + finalI);
            });
            Integer totalPrice = 0;
            for (int j = 1; j < 101 ; j++) {
                SaleOrderDetails saleOrderDetails1 = saleOrderDetailsRepository.findById(j).orElseThrow(() -> {
                    throw new NotFoundException("Not found with id = " + finalI);
                });
                if (saleOrderDetails1.getSaleOrder().getId().equals(saleOrder.getId())) {
                    totalPrice += saleOrderDetails1.getTotal_price_by_product();
                }
            }
            System.out.println("TOTAL PRICE = " +totalPrice);
            saleOrder.setTotalPrice(totalPrice);
            saleOrderRepository.save(saleOrder);
        }
    }

    @Test
    public void givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        System.out.println(generatedString);
    }

}
