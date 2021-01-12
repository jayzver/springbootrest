package net.oneqas.services.DAO.groupAggregate;

import net.oneqas.services.DAO.DAO;

import java.util.List;

public interface DAOGroupAggregate extends DAO
{
    List<?> getByParentId(Long parentId);
}
