package net.oneqas;

import javax.persistence.Column;

//@MappedSuperclass
public class BaseEntity
{
    @Column(name = "name_target")
    protected String nameTarget;

    @Column(name = "img_url")
    protected String imgUrl;

    @Column(name = "descript")
    protected String description;

    @Column(name = "parent_id")
    protected Long parentId;

    public String getNameTarget()
    {
        return nameTarget;
    }

    public void setNameTarget(String nameTarget)
    {
        this.nameTarget = nameTarget;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
