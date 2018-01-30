package com.startwithjava.simpleblog.repositories;
import org.hibernate.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class JpaDao<T,ID extends Serializable> implements JpaRepository<T,ID>{
    @PersistenceContext
    private EntityManager em;

    public List<T> findByCriteria(Criteria criteria){
      //  Criteria criteria =
        return null;
    }
}
