package net.oneqas.aggregate.model;

import javax.persistence.*;

@Entity
@Table(name = "additional_properties")
public class AdditionalProperties
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aggregate_id")
    private Long aggregateId;

    @Column(name = "name_properties")
    private String nameProperties;

    @Column(name = "value_properties")
    private String valueProperties;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getAggregateId()
    {
        return aggregateId;
    }

    public void setAggregateId(Long aggregateId)
    {
        this.aggregateId = aggregateId;
    }

    public String getNameProperties()
    {
        return nameProperties;
    }

    public void setNameProperties(String nameProperties)
    {
        this.nameProperties = nameProperties;
    }

    public String getValueProperties()
    {
        return valueProperties;
    }

    public void setValueProperties(String valueProperties)
    {
        this.valueProperties = valueProperties;
    }
}
