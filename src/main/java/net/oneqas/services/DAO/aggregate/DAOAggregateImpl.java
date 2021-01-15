package net.oneqas.services.DAO.aggregate;

import net.oneqas.entity.BaseEntity;
import net.oneqas.entity.aggregate.Aggregate;
import net.oneqas.services.JPA.aggregate.JPAAggregate;
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
    private JPAAggregate jpa;

    public DAOAggregateImpl(@Autowired JPAAggregate jpa, EntityManager entityManager)
    {
        this.manager = entityManager;
        this.jpa = jpa;
    }

    @Override
    public BaseEntity getByParentId(Long parentId)
    {
        System.out.println("getByParentId");
        BaseEntity aggregate = this.jpa.getByParentId(parentId);
        return aggregate;
    }

    @Override
    public BaseEntity getFirstByGroupId(Long groupId)
    {
        System.out.println("getFirstByGroupId");
        BaseEntity aggregate = this.jpa.getFirstByGroupId(groupId);
        return aggregate;
    }

    @Override
    public List<?> getChildrenByParentId(Long parentId)
    {
        System.out.println("getChildrenByParentId");
        List<?> children = this.jpa.getChildrenByParentId(parentId);
        return children;
    }

    @Override
    public List<?> getChildrenByGroupId(Long groupId)
    {
        System.out.println("getChildrenByGroupId");
        List<?> children = this.jpa.getChildrenByGroupId(groupId);
        return children;
    }

    @Override
    public void save(BaseEntity entity)
    {
        System.out.println("save");
        this.jpa.save((Aggregate) entity);
    }

    @Override
    public void update(BaseEntity entity)
    {
        System.out.println("update");
        Aggregate newAggregate = (Aggregate) entity;
        Aggregate aggregate = this.jpa.getOne(newAggregate.getId());
        this.copy(aggregate, newAggregate);
    }

    @Override
    public void delete(Long id)
    {
        System.out.println("delete");
        Aggregate aggregate = this.jpa.getOne(id);
        this.jpa.delete(aggregate);
    }

    @Override
    public void copy(BaseEntity oldAggregate, BaseEntity newAggregate)
    {
        Aggregate oldAggr = (Aggregate) oldAggregate;
        Aggregate newAggr = (Aggregate) newAggregate;
        oldAggr.setGroupId(newAggr.getGroupId());
        oldAggr.setQuantity(newAggr.getQuantity());
        oldAggr.setSerialKey(newAggr.getSerialKey());
        oldAggr.setDescription(newAggr.getDescription());
        oldAggr.setImgUrl(newAggr.getImgUrl());
        oldAggr.setNameTarget(newAggr.getNameTarget());
        oldAggr.setParentId(newAggr.getParentId());
    }

    @Override
    public BaseEntity getById(Long id)
    {
        System.out.println("geById");
        Aggregate aggregate = this.jpa.getOne(id);
        return aggregate;
    }

    @Override
    public BaseEntity parseFromJson(String data)
    {
        System.out.println("parseFromJson");
        return null;
    }
}
