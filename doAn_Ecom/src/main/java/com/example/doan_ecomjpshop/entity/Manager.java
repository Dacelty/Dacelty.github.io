package com.example.doan_ecomjpshop.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
public class Manager implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String email;

    private String password;

    @Type(type = "json")
    @Column(name = "roles", columnDefinition = "json")
    private List<String> roles;
}
