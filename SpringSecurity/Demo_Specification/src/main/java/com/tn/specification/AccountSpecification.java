package com.tn.specification;

import com.tn.entity.Account;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountSpecification {

    public static Specification<Account> buildWhere(String username, Integer minId, String email) {
        Specification<Account> where = null;

        if (username != null) {
            CustomSpecification usernameCus = new CustomSpecification("username", username);
            where = Specification.where(usernameCus);
        }

        if (minId != null) {
            CustomSpecification minIdCus = new CustomSpecification("minId", minId);
            if (where == null) {
                where = minIdCus;
            } else {
                where = where.and(minIdCus);
            }
        }

        if (email != null) {
            CustomSpecification emailCus = new CustomSpecification("email", email);
            if (where == null) {
                where = emailCus;
            } else {
                where = where.and(emailCus);
            }
        }

        return where;
    }

}

@RequiredArgsConstructor
class CustomSpecification implements Specification<Account> {

    @NonNull
    private String field;

    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (field.equalsIgnoreCase("username")) {
            return criteriaBuilder.like(root.get("username"), "%" + value + "%");
        }
        if (field.equalsIgnoreCase("minId")) {
            return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());
        }

        if (field.equalsIgnoreCase("email")) {
            return criteriaBuilder.like(root.get("email"), "%" + value + "%");
        }

        return null;
    }

}
