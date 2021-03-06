package net.oneqas.entity.aggregate;

import net.oneqas.entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

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

    @Column(name = "parent_id")
    protected Long parentId;

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "aggregate_id")
    private Set<AggregateImg> images;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "aggregate_id")
    private Set<AggregateFile> files;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "aggregate_id")
    private Set<AdditionalProperties> additionalProperties;

    public Set<AdditionalProperties> getAdditionalProperties()
    {
        return additionalProperties;
    }

    public void setAdditionalProperties(Set<AdditionalProperties> additionalProperties)
    {
        this.additionalProperties = additionalProperties;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "aggregate_provider", joinColumns = {@JoinColumn(name = "aggregate_id")},
    inverseJoinColumns = {@JoinColumn(name = "provider_id")})
    private Set<Provider> providers;

    public Set<Provider> getProviders()
    {
        return providers;
    }

    public void setProviders(Set<Provider> providers)
    {
        this.providers = providers;
    }

    public Set<AggregateFile> getFiles()
    {
        return files;
    }

    public void setFiles(Set<AggregateFile> files)
    {
        this.files = files;
    }

    public Set<AggregateImg> getImages()
    {
        return images;
    }

    public void setImages(Set<AggregateImg> images)
    {
        this.images = images;
    }

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

    @Override
    public String toString()
    {
        return "Aggregate{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", quantity=" + quantity +
                ", serialKey='" + serialKey + '\'' +
                ", images=" + images +
                ", files=" + files +
                ", additionalProperties=" + additionalProperties +
                ", providers=" + providers +
                ", nameTarget='" + nameTarget + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", description='" + description + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
