package net.oneqas.groupAggregate.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

//@MappedSuperclass
public class BaseEntity
{
    @Column(name = "descript")
    private String description;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public long id;

//    public long getId()
//    {
//        return id;
//    }
//
//    public void setId(long id)
//    {
//        this.id = id;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "BaseEntity{" +
//                "id=" + id +
//                '}';
//    }
}
