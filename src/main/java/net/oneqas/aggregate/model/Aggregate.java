package net.oneqas.aggregate.model;

import net.oneqas.commonClasses.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "aggregate")
public class Aggregate extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "serial_key")
    private String serialKey;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Long getGroupId()
    {
        return groupId;
    }

    public void setGroupId(Long groupId)
    {
        this.groupId = groupId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getSerialKey()
    {
        return serialKey;
    }

    public void setSerialKey(String serialKey)
    {
        this.serialKey = serialKey;
    }
}
