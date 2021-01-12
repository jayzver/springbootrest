package net.oneqas.services.DAO.groupAggregate;

import net.oneqas.entity.BaseEntity;
import net.oneqas.entity.groupAggregate.GroupAggregate;
import net.oneqas.services.JPA.GroupAggregate.JPAGroupAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class DAOGroupAggregateImp implements DAOGroupAggregate
{
    private final JPAGroupAggregate groupAggregateRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    public DAOGroupAggregateImp(@Autowired JPAGroupAggregate groupAggregateRepository,
                                EntityManager entityManager)
    {
        this.groupAggregateRepository = groupAggregateRepository;
        this.entityManager = entityManager;
    }

    @Override
    public void delete(Long id)
    {
        System.out.println("GroupAggregateServiceImplemented.delete("+id+")");
        this.groupAggregateRepository.deleteById(id);
    }

    @Override
    public GroupAggregate update(BaseEntity entity)
    {
        GroupAggregate group = (GroupAggregate) entity;
        GroupAggregate desired = this.groupAggregateRepository.getOne(group.getId());
        if (desired == null || desired.getId() == 0)
        {
            return null;
        }
        DAOGroupAggregateImp.copy(desired, group);
        this.groupAggregateRepository.flush();
        return desired;
    }

    @Override
    public void save(BaseEntity entity)
    {
        GroupAggregate group = (GroupAggregate) entity;
        System.out.println("GroupAggregateServiceImplemented.save("+group+")");
        this.groupAggregateRepository.save(group);
    }

    @Override
    public List<GroupAggregate> getByParentId(Long parentId)
    {
        System.out.println("GroupAggregateServiceImplemented.getGroupsByParentId");
        if (this.entityManager != null)
        {
            Query query = this.entityManager.createNativeQuery(
                    "SELECT * FROM group_aggregate WHERE parent_id="+ parentId +";", GroupAggregate.class);
            return query.getResultList();
        }
        return null;
    }

    @Override
    public GroupAggregate getById(Long id)
    {
        System.out.println("GroupAggregateServiceImplemented.getById("+id+")");
        return this.groupAggregateRepository.findById(id).get();
    }

    public static GroupAggregate setDefault(GroupAggregate group)
    {
        group.setNameTarget("Главная");
        group.setImgUrl("");
        group.setDescription("");
        group.setTypeOfChildren(1);
        group.setParentId(-1L);
        return group;
    }

    public static void copy(GroupAggregate oldGroup, GroupAggregate newGroup)
    {
        oldGroup.setNameTarget(newGroup.getNameTarget());
        oldGroup.setDescription(newGroup.getDescription());
        oldGroup.setImgUrl(newGroup.getImgUrl());
    }

    public static GroupAggregate parseFromJson(String object)
    {
//        {"typeOfChildren":1,"nameGroup":"name of group aggregate","imageUrl":"electric.jpg"}
        int indexStart = 0;
        int indexEnd = 0;
        GroupAggregate groupAggregate = new GroupAggregate();
        StringBuilder builder = new StringBuilder(object);
        for (int i = 0; i < builder.length(); i++)
        {
            if (builder.charAt(i) == '"' || builder.charAt(i) == '{' || builder.charAt(i) == '}')
            {
                builder.deleteCharAt(i);
                i--;
            }
        }
        String param = "";
        String value = "";
        indexStart = builder.indexOf(":");
        if (indexStart < 1)
        {
            return null;
        }
        do
        {
            param = builder.substring(0, indexStart);
            indexEnd = builder.indexOf(",");
            indexEnd = (indexEnd != -1) ? indexEnd : builder.length();
            value = builder.substring(indexStart+1, indexEnd);
            switch (param)
            {
                case "nameTarget":
                {
                    groupAggregate.setNameTarget(value);
                }break;
                case "imgUrl":
                {
                    groupAggregate.setImgUrl(value);
                }break;
                case "description":
                {
                    groupAggregate.setDescription(value);
                }break;
                case "id":
                {
                    try
                    {
                        groupAggregate.setId(Long.parseLong(value));
                    } catch (NumberFormatException e)
                    {
                        System.out.println(e.getMessage());
                        return  null;
                    }
                }break;
                case "typeOfChildren":
                {
                    try
                    {
                        groupAggregate.setTypeOfChildren(Integer.parseInt(value));
                    } catch (NumberFormatException e)
                    {
                        System.out.println(e.getMessage());
                        return null;
                    }
                }break;
                case "parentId":
                {
                    try
                    {
                        groupAggregate.setParentId(Long.parseLong(value));
                    } catch (NumberFormatException e)
                    {
                        System.out.println(e.getMessage());
                        return null;
                    }
                }break;
            }
            builder.delete(0, indexEnd+1);
            indexStart = builder.indexOf(":");
        }while (indexStart != -1);
        int i = 0;
        return groupAggregate;
    }
}
