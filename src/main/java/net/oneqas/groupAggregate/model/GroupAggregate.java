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

    @Override
    public String toString()
    {
        return "GroupAggregate{" +
                "id=" + id +
                ", nameGroup='" + nameGroup + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", parentId=" + parentId +
                ", typeOgChildren=" + typeOfChildren +
                '}';
    }
}
