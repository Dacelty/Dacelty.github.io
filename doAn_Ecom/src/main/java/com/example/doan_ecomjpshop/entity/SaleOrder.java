package com.example.doan_ecomjpshop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class SaleOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String phone;

    private String email;

    private LocalDateTime createdAt;

    private Integer totalPrice;

    private String code;

    private boolean status;

    @JsonManagedReference
    @OneToMany(mappedBy = "saleOrder", orphanRemoval = true)
    private List<SaleOrderDetails> saleOrderDetailses = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
