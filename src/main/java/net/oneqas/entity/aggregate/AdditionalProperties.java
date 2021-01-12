package net.oneqas.entity.aggregate;

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

    @Column(name = "prop_name")
    private String propName;

    @Column(name = "prop_value")
    private String propValue;

    @ManyToOne
    @JoinColumn(name = "aggregate_id")
    private Aggregate aggregate;

    public Aggregate getAggregate()
    {
        return aggregate;
    }

    public void setAggregate(Aggregate aggregate)
    {
        this.aggregate = aggregate;
    }

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

    public String getPropName()
    {
        return propName;
    }

    public void setPropName(String nameProperties)
    {
        this.propName = nameProperties;
    }

    public String getPropValue()
    {
        return propValue;
    }

    public void setPropValue(String valueProperties)
    {
        this.propValue = valueProperties;
    }
}
