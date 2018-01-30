package com.startwithjava.simpleblog.repositories;
import com.startwithjava.simpleblog.entities.AbstractEntity;
import org.hibernate.Criteria;
import java.util.List;
public class AbtractDaoImpl implements AbstractDao<AbstractEntity>{
    @Override
    public List<AbstractEntity> findByCriteria(Criteria criteria) {
        return null;
    }
}
