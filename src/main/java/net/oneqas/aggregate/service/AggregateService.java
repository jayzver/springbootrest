package net.oneqas.aggregate.service;

import net.oneqas.aggregate.model.Aggregate;

import java.util.List;
import java.util.Optional;

public interface AggregateService
{
    Optional<Aggregate> getById(long id);
    void save(Aggregate aggregate);
    void delete(Long id);
    List<Aggregate> getAll();
}
