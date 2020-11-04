package net.oneqas.groupAggregate.service;

import net.oneqas.groupAggregate.model.GroupAggregate;
import net.oneqas.groupAggregate.repository.GroupAggregateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupaggregateServiceImplementation implements GroupAggregateService
{
    private final GroupAggregateRepository groupAggregateRepository;

    public GroupaggregateServiceImplementation(GroupAggregateRepository groupAggregateRepository)
    {
        this.groupAggregateRepository = groupAggregateRepository;
    }

    @Override
    public Optional<GroupAggregate> getById(Long id)
    {
        return this.groupAggregateRepository.findById(id);
    }

    @Override
    public void save(GroupAggregate group)
    {

    }

    @Override
    public void delete(Long id)
    {

    }

    @Override
    public List<GroupAggregate> getAll()
    {
        return null;
    }
}
