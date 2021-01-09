package net.oneqas.aggregate.model;

import javax.persistence.*;

@Entity
@Table(name = "aggregate_file")
public class AggregateFile
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_aggregate")
    private long idAggregate;

    @Column(name = "file_url")
    private String fileUrl;

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

    public String getFileUrl()
    {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl)
    {
        this.fileUrl = fileUrl;
    }
}
