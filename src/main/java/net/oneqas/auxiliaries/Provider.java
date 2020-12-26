package net.oneqas.auxiliaries;

import javax.persistence.*;

@Entity
@Table(name = "provider")
public class Provider
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "intern_address")
    private String internAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "descript")
    private String description;

    @Column(name = "phone")
    private String phone;

    @Column(name = "physical_address")
    private String physicalAddress;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "price")
    private Float price;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getProviderName()
    {
        return providerName;
    }

    public void setProviderName(String providerName)
    {
        this.providerName = providerName;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public Float getPrice()
    {
        return price;
    }

    public void setPrice(Float price)
    {
        this.price = price;
    }
}