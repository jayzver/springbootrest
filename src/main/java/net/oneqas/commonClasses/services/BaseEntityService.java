package net.oneqas.commonClasses.services;

import net.oneqas.commonClasses.BaseEntity;
import net.oneqas.groupAggregate.model.GroupAggregate;

import java.util.List;

public interface BaseEntityService
{
    List<?> getByParentId(Long id);
    void delete(Long id);
    BaseEntity update(BaseEntity group);
    void save(BaseEntity group);
    BaseEntity getById(Long id);
//    List<GroupAggregate> getAll();
}
