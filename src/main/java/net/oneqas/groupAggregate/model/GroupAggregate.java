package net.oneqas.groupAggregate.model;

import javax.persistence.*;

@Entity
@Table(name = "group_aggregate")
public class GroupAggregate
{
//    @Transient
//    @PersistenceContext
//    EntityManager entityManager;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "parent_id")
    private long parentId;

    /**
     * 0 - non
     * 1 - GroupAggregate
     * 2 - Aggregate
     */
    @Column(name = "type_of_children")
    private int typeOfChildren;

    @Column(name = "descript")
    private String description;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
//    @OneToMany
//    @Query(value = "SELECT * FROM group_aggregate WHERE parent_id="+this.id, nativeQuery = true)
//    @Transient
//    private List<GroupAggregate> groups;
//    @Transient

    //    @OneToMany
//    private List<Aggregate> aggregates;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getNameGroup()
    {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup)
    {
        this.nameGroup = nameGroup;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public long getParentId()
    {
        return parentId;
    }

    public void setParentId(long parentId)
    {
        this.parentId = parentId;
    }

    public int getTypeOfChildren()
    {
        return typeOfChildren;
    }

    public void setTypeOfChildren(int typeOgChildren)
    {
        this.typeOfChildren = typeOgChildren;
    }

    public GroupAggregate parseFromJson(String object)
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
            }
        }
        String param = "";
        String value = "";
        do
        {
            indexStart = builder.indexOf(":");
            param = builder.substring(0, indexStart-1);
            indexEnd = builder.indexOf(",");
            value = builder.substring(indexStart+1, indexEnd-1);
            switch (param)
            {
                case "nameGroup":
                {
                    groupAggregate.nameGroup = value;
                }break;
                case "imageUrl":
                {
                    groupAggregate.imageUrl = value;
                }break;
                case "typeOfChildren":
                {

                }break;
                case "parentId":
                {
                    try
                    {
                        groupAggregate.parentId = Integer.parseInt(value);
                    } catch (NumberFormatException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }break;
            }
            builder.delete(0, indexEnd);
        }while (indexStart != -1);
        return groupAggregate;
    }

    @Override
    public String toString()
    {
        return "GroupAggregate{" +
                "id=" + id +
                ", nameGroup='" + nameGroup + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", parentId=" + parentId +
                ", typeOfChildren=" + typeOfChildren +
                ", description='" + description + '\'' +
                '}';
    }
}
