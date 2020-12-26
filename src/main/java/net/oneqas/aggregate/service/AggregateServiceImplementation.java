package net.oneqas.aggregate.service;

import net.oneqas.aggregate.repository.AggregateRepository;
import net.oneqas.auxiliaries.AdditionalProperties;
import net.oneqas.auxiliaries.Provider;
import net.oneqas.commonClasses.BaseEntity;
import net.oneqas.commonClasses.services.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AggregateServiceImplementation implements BaseEntityService
{
    @PersistenceContext
    private final EntityManager entityManager;

    public AggregateServiceImplementation(@Autowired AggregateRepository repository, EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<?> getByParentId(Long id)
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

    public List<String> getPhotosById(Long id)
    {
        return null;
    }

    public List<String> getFilesById(Long id)
    {
        return  null;
    }

    public List<Provider> getProvidersById(Long id)
    {
        return null;
    }

    public List<AdditionalProperties> getAdditionalPropertiesById(Long id)
    {
        return null;
    }
}
