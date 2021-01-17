package net.oneqas.entity.aggregate;

import javax.persistence.*;

@Entity
@Table(name = "aggregate_img")
public class AggregateImg
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "aggregate_id")
    private long idAggregate;

    @Column(name = "img_url")
    private String imgUrl;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "aggregate_id", insertable = false, updatable = false)
//    private Aggregate aggregate;
//
//    public Aggregate getAggregate()
//    {
//        return aggregate;
//    }
//
//    public void setAggregate(Aggregate aggregate)
//    {
//        this.aggregate = aggregate;
//    }

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

    @Override
    public String toString()
    {
        return "AggregateImg{" +
                "id=" + id +
                ", idAggregate=" + idAggregate +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
