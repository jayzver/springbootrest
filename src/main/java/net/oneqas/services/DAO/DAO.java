package net.oneqas.services.DAO;

import net.oneqas.entity.BaseEntity;

public interface DAO
{
    void delete(Long id);
    BaseEntity update(BaseEntity group);
    void save(BaseEntity group);
    BaseEntity getById(Long id);
}
