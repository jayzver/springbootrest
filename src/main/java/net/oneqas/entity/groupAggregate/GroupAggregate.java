package net.oneqas.entity.groupAggregate;

import net.oneqas.entity.BaseEntity;

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
