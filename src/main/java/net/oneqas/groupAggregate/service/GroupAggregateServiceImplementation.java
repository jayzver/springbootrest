package net.oneqas.groupAggregate.service;

import net.oneqas.groupAggregate.model.GroupAggregate;
import net.oneqas.groupAggregate.repository.GroupAggregateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupAggregateServiceImplementation implements GroupAggregateService
{
    private final GroupAggregateRepository groupAggregateRepository;

    public GroupAggregateServiceImplementation(@Autowired GroupAggregateRepository groupAggregateRepository)
    {
        this.groupAggregateRepository = groupAggregateRepository;
    }

    @Override
    public Optional<GroupAggregate> getById(Long id)
    {
        System.out.println("GroupAggregateServiceImplemented.getById("+id+")");
        return this.groupAggregateRepository.findById(id);
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
}
