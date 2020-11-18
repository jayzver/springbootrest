package net.oneqas.groupAggregate.service;

import net.oneqas.groupAggregate.model.GroupAggregate;

import java.util.List;

public interface GroupAggregateService
{
    List<GroupAggregate> getChilds(Long id);
    GroupAggregate getById(Long id);
    void save(GroupAggregate group);
    void delete(Long id);
    List<GroupAggregate> getAll();
}
