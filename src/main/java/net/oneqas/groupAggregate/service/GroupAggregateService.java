package net.oneqas.groupAggregate.service;

import net.oneqas.groupAggregate.model.GroupAggregate;

import java.util.List;

public interface GroupAggregateService
{
    List<GroupAggregate> getGroupsByParentId(Long id);
    void delete(Long id);
    void save(GroupAggregate group);
    GroupAggregate getById(Long id);
//    List<GroupAggregate> getAll();
}
