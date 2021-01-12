package net.oneqas.services.DAO.aggregate;

import net.oneqas.services.JPA.aggregate.JPAAggregate;
import net.oneqas.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class DAOAggregateImpl implements DAOAggregate
{
    @PersistenceContext
    private final EntityManager manager;
    private JPAAggregate repository;

    public DAOAggregateImpl(@Autowired JPAAggregate repository, EntityManager entityManager)
    {
        this.manager = entityManager;
        this.repository = repository;
    }

    @Override
    public BaseEntity getByParentId(Long id)
    {
        return null;
    }

    @Override
    public BaseEntity getFirst(Long groupId)
    {
        return null;
    }

    @Override
    public List<?> getChildFirst(Long groupId)
    {
        return null;
    }

    @Override
    public List<?> getChildById(Long id)
    {
        return null;
    }

    @Override
    public void delete(Long id)
    {

    }

    @Override
    public BaseEntity update(BaseEntity group)
    {
        return null;
    }

    @Override
    public void save(BaseEntity group)
    {

    }

    @Override
    public BaseEntity getById(Long id)
    {
        return null;
    }
}
