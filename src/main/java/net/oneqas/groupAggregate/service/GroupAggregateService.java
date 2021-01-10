package net.oneqas.groupAggregate.service;

import net.oneqas.commonClasses.services.BaseEntityService;

import java.util.List;

public interface GroupAggregateService extends BaseEntityService
{
    List<?> getByParentId(Long parentId);
}
