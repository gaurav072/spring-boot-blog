package com.startwithjava.simpleblog.repositories;

import com.startwithjava.simpleblog.entities.AbstractEntity;
import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface AbstractDao<T>{
    List<T> findByCriteria(Criteria criteria);
}
