package net.oneqas.aggregate.service;

import net.oneqas.aggregate.repository.AggregateRepository;
import net.oneqas.aggregate.model.AdditionalProperties;
import net.oneqas.aggregate.model.Provider;
import net.oneqas.commonClasses.BaseEntity;
import net.oneqas.commonClasses.services.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AggregateServiceImplementation implements AggregateService
{
    @PersistenceContext
    private final EntityManager manager;
    private AggregateRepository repository;

    public AggregateServiceImplementation(@Autowired AggregateRepository repository, EntityManager entityManager)
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
