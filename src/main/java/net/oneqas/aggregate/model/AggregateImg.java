package net.oneqas.aggregate.model;

import javax.persistence.*;

@Entity
@Table(name = "aggregate_img")
public class AggregateImg
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_aggregate")
    private long idAggregate;

    @Column(name = "img_url")
    private String imgUrl;

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

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }
}
