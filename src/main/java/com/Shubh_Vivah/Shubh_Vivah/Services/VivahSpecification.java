package com.Shubh_Vivah.Shubh_Vivah.Services;

import org.springframework.data.jpa.domain.Specification;

import com.Shubh_Vivah.Shubh_Vivah.Model.VivahModel;

public class VivahSpecification {

    public static Specification<VivahModel> filterBy(
            String gender, String religion, String country,
            String state, String language) {

        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (gender != null && !gender.isBlank()) {
                predicates = cb.and(predicates, cb.equal(root.get("gender"), gender));
            }
            if (religion != null && !religion.isBlank()) {
                predicates = cb.and(predicates, cb.equal(root.get("religion"), religion));
            }
            if (country != null && !country.isBlank()) {
                predicates = cb.and(predicates, cb.equal(root.get("country"), country));
            }
            if (state != null && !state.isBlank()) {
                predicates = cb.and(predicates, cb.equal(root.get("state"), state));
            }
            if (language != null && !language.isBlank()) {
                predicates = cb.and(predicates, cb.like(root.get("language"), "%" + language + "%"));
            }

            return predicates;
        };
    }
}