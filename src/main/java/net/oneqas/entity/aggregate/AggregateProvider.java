package net.oneqas.entity.aggregate;

import javax.persistence.*;

@Entity
@Table(name = "aggregate_provider")
public class AggregateProvider
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_aggregate")
    private long idAggregate;

    @Column(name = "id_provider")
    private long idProvider;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getIdAggregate()
    {
        return idAggregate;
    }

    public void setIdAggregate(long idAggregate)
    {
        this.idAggregate = idAggregate;
    }

    public long getIdProvider()
    {
        return idProvider;
    }

    public void setIdProvider(long idProvider)
    {
        this.idProvider = idProvider;
    }
}
