package net.oneqas.groupAggregate.model;

import net.oneqas.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "group_aggregate")
public class GroupAggregate extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 0 - non
     * 1 - GroupAggregate
     * 2 - Aggregate
     */
    @Column(name = "type_of_children")
    private int typeOfChildren;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public int getTypeOfChildren()
    {
        return typeOfChildren;
    }

    public void setTypeOfChildren(int typeOgChildren)
    {
        this.typeOfChildren = typeOgChildren;
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
            value = builder.substring(indexStart+1, indexEnd);
            switch (param)
            {
                case "nameGroup":
                {
                    groupAggregate.nameTarget = value;
                }break;
                case "imageUrl":
                {
                    groupAggregate.imgUrl = value;
                }break;
                case "description":
                {
                    groupAggregate.description = value;
                }break;
                case "typeOfChildren":
                {
                    try
                    {
                        groupAggregate.typeOfChildren = Integer.parseInt(value);
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
                        groupAggregate.parentId = Long.parseLong(value);
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

    @Override
    public String toString()
    {
        return "GroupAggregate{" +
                "id=" + id +
                ", nameGroup='" + nameTarget + '\'' +
                ", imageUrl='" + imgUrl + '\'' +
                ", parentId=" + parentId +
                ", typeOfChildren=" + typeOfChildren +
                ", description='" + description + '\'' +
                '}';
    }
}
//    @Transient
//    @PersistenceContext
//    EntityManager entityManager;

//    @OneToMany
//    @Query(value = "SELECT * FROM group_aggregate WHERE parent_id="+this.id, nativeQuery = true)
//    @Transient
//    private List<GroupAggregate> groups;
//    @Transient

    //    @OneToMany
//    private List<Aggregate> aggregates;
