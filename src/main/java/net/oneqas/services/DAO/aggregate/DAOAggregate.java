package net.oneqas.services.DAO.aggregate;

import net.oneqas.entity.BaseEntity;
import net.oneqas.services.DAO.DAO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DAOAggregate extends DAO
{
    BaseEntity getByParentId(Long parentId);
    BaseEntity getFirstByGroupId(Long groupId);
    List<?> getChildrenByParentId(Long parentId);
    List<?> getChildrenByGroupId(Long groupId);
}
