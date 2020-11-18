package net.oneqas.groupAggregate.service;

import net.oneqas.groupAggregate.model.GroupAggregate;
import net.oneqas.groupAggregate.repository.GroupAggregateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class GroupAggregateServiceImplementation implements GroupAggregateService
{
    private final GroupAggregateRepository groupAggregateRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    public GroupAggregateServiceImplementation(@Autowired GroupAggregateRepository groupAggregateRepository, EntityManager entityManager)
    {
        this.groupAggregateRepository = groupAggregateRepository;
        this.entityManager = entityManager;
    }

    @Override
    public GroupAggregate getById(Long id)
    {
        System.out.println("GroupAggregateServiceImplemented.getById("+id+")");
        return this.groupAggregateRepository.findById(id).get();
    }

    @Override
    public void save(GroupAggregate group)
    {
        System.out.println("GroupAggregateServiceImplemented.save("+group+")");
        this.groupAggregateRepository.save(group);
    }

    @Override
    public void delete(Long id)
    {
        System.out.println("GroupAggregateServiceImplemented.delete("+id+")");
        this.groupAggregateRepository.deleteById(id);
    }

    @Override
    public List<GroupAggregate> getAll()
    {
        System.out.println("GroupAggregateServiceImplemented.getAll");
        return this.groupAggregateRepository.findAll();
    }

    @Override
    public List<GroupAggregate> getChilds(Long id)
    {
        if (this.entityManager != null)
        {
            Query query = this.entityManager.createNativeQuery(
                    "SELECT * FROM group_aggregate WHERE parent_id="+id+";", GroupAggregate.class);
            return query.getResultList();
        }
        return null;
    }
}
