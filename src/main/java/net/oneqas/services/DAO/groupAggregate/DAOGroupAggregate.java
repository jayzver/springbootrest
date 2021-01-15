package net.oneqas.services.DAO.groupAggregate;

import net.oneqas.entity.groupAggregate.GroupAggregate;
import net.oneqas.services.DAO.DAO;

import java.util.List;

public interface DAOGroupAggregate extends DAO
{
    List<GroupAggregate> getByParentId(Long parentId);
    GroupAggregate setDefault(GroupAggregate groupAggregate);
}
