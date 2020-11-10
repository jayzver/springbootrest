package net.oneqas.groupAggregate.service;

import net.oneqas.groupAggregate.model.GroupAggregate;

import java.util.List;
import java.util.Optional;

public interface GroupAggregateService
{
    List<GroupAggregate> getChild(Long id);
    Optional<GroupAggregate> getById(Long id);
    void save(GroupAggregate group);
    void delete(Long id);
    List<GroupAggregate> getAll();
}
