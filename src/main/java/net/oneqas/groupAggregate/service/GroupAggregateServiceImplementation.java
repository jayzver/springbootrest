package net.oneqas.groupAggregate.service;

import net.oneqas.commonClasses.BaseEntity;
import net.oneqas.commonClasses.services.BaseEntityService;
import net.oneqas.groupAggregate.model.GroupAggregate;
import net.oneqas.groupAggregate.repository.GroupAggregateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class GroupAggregateServiceImplementation implements BaseEntityService
{
    private final GroupAggregateRepository groupAggregateRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    public GroupAggregateServiceImplementation(@Autowired GroupAggregateRepository groupAggregateRepository,
                                               EntityManager entityManager)
    {
        this.groupAggregateRepository = groupAggregateRepository;
        this.entityManager = entityManager;
    }

    @Override
    public void delete(Long id)
    {
        System.out.println("GroupAggregateServiceImplemented.delete("+id+")");
        this.groupAggregateRepository.deleteById(id);
    }

    @Override
    public GroupAggregate update(BaseEntity entity)
    {
        GroupAggregate group = (GroupAggregate) entity;
        GroupAggregate desired = this.groupAggregateRepository.getOne(group.getId());
        if (desired == null || desired.getId() == 0)
        {
            return null;
        }
        desired.copy(group);
        this.groupAggregateRepository.flush();
        return desired;
    }

    @Override
    public void save(BaseEntity entity)
    {
        GroupAggregate group = (GroupAggregate) entity;
        System.out.println("GroupAggregateServiceImplemented.save("+group+")");
        this.groupAggregateRepository.save(group);
    }

    @Override
    public List<GroupAggregate> getByParentId(Long id)
    {
        System.out.println("GroupAggregateServiceImplemented.getGroupsByParentId");
        if (this.entityManager != null)
        {
            Query query = this.entityManager.createNativeQuery(
                    "SELECT * FROM group_aggregate WHERE parent_id="+id+";", GroupAggregate.class);
            return query.getResultList();
        }
        return null;
    }

    @Override
    public GroupAggregate getById(Long id)
    {
        System.out.println("GroupAggregateServiceImplemented.getById("+id+")");
        return this.groupAggregateRepository.findById(id).get();
    }

//    @Override
//    public List<GroupAggregate> getAll()
//    {
//        System.out.println("GroupAggregateServiceImplemented.getAll");
//        return this.groupAggregateRepository.findAll();
//    }

}
