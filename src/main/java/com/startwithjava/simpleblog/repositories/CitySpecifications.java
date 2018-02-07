package com.startwithjava.simpleblog.repositories;
import com.startwithjava.simpleblog.entities.City;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CitySpecifications {
    public static Specification<City> hasCountry(){
        return new Specification<City>(){
            @Override
            public Predicate toPredicate(Root<City> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("country"), "India");
            }
        };
    }
}
class CitySpecification implements Specification<City> {
    @Override
    public Predicate toPredicate(Root<City> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
