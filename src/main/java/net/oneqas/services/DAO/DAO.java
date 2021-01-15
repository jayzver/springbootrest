package net.oneqas.services.DAO;

import net.oneqas.entity.BaseEntity;
import net.oneqas.entity.groupAggregate.GroupAggregate;

import java.util.List;

public interface DAO
{
    void save(BaseEntity entity);
    void update(BaseEntity entity);
    void delete(Long Id);
    void copy(BaseEntity oldGroup, BaseEntity newGroup);
    BaseEntity getById(Long id);
    BaseEntity parseFromJson(String data);
}
