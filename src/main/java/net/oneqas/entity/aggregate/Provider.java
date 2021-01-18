package net.oneqas.entity.aggregate;

import net.oneqas.entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "provider")
public class Provider extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "internet_address")
    private String internAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "physical_address")
    private String physicalAddress;

//    @ManyToMany(fetch = FetchType.LAZY)
//    private Set<Aggregate> aggregates;
//
//    public Set<Aggregate> getAggregates()
//    {
//        return aggregates;
//    }
//
//    public void setAggregates(Set<Aggregate> aggregates)
//    {
//        this.aggregates = aggregates;
//    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getInternAddress()
    {
        return internAddress;
    }

    public void setInternAddress(String internAddress)
    {
        this.internAddress = internAddress;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhysicalAddress()
    {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress)
    {
        this.physicalAddress = physicalAddress;
    }

    @Override
    public String toString()
    {
        return "Provider{" +
                "id=" + id +
                ", internAddress='" + internAddress + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                ", nameTarget='" + nameTarget + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
