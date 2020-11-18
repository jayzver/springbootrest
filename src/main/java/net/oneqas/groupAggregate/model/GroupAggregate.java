package net.oneqas.groupAggregate.model;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "has_group")
    private int hasGroup;

    @Column(name = "has_aggregate")
    private int hasAggregate;

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

    public int getHasGroup()
    {
        return hasGroup;
    }

    public void setHasGroup(int hasGroup)
    {
        this.hasGroup = hasGroup;
    }

    public int getHasAggregate()
    {
        return hasAggregate;
    }

    public void setHasAggregate(int hasAggregate)
    {
        this.hasAggregate = hasAggregate;
    }

    @Override
    public String toString()
    {
        return "GroupAggregate{" +
                "id=" + id +
                ", nameGroup='" + nameGroup + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", parentId=" + parentId +
                ", hasGroup=" + hasGroup +
                ", hasAggregate=" + hasAggregate +
                '}';
    }
}
