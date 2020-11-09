package net.oneqas.aggregate.service;

import net.oneqas.aggregate.model.Aggregate;

import java.util.List;
import java.util.Optional;

public class AggregateServiceImplementation implements AggregateService
{
    @Override
    public Optional<Aggregate> getById(long id)
    {
        return Optional.empty();
    }

    @Override
    public void save(Aggregate aggregate)
    {

    }

    @Override
    public void delete(Long id)
    {

    }

    @Override
    public List<Aggregate> getAll()
    {
        return null;
    }
}
