package net.oneqas.services.DAO.aggregate;

import net.oneqas.services.JPA.aggregate.JPAAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class DAOAggregateImpl implements DAOAggregate
{
    @PersistenceContext
    private final EntityManager manager;
    private JPAAggregate jpa;

    public DAOAggregateImpl(@Autowired JPAAggregate jpa, EntityManager entityManager)
    {
        this.manager = entityManager;
        this.jpa = jpa;
    }
}
