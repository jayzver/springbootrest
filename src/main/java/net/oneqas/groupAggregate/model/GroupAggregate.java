package net.oneqas.groupAggregate.model;
import net.oneqas.aggregate.model.Aggregate;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groupAggregate")
public class GroupAggregate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nameGroup")
    private String nameGroup;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "parentId")
    private long parentId;
    @OneToMany
    private List<GroupAggregate> groups;
    @OneToMany
    private List<Aggregate> aggregates;

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

    @Override
    public String toString()
    {
        return "GroupAggregate{" +
                "id=" + id +
                ", nameGroup='" + nameGroup + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
