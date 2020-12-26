package net.oneqas.commonClasses.proxyEntity;

import net.oneqas.commonClasses.BaseEntity;

import java.util.List;

public class ProxyEntity
{
    protected BaseEntity parent;
    protected List<BaseEntity> children;

    public ProxyEntity(BaseEntity parent, List<BaseEntity> children)
    {
        this.parent = parent;
        this.children = children;
    }

    public BaseEntity getParent()
    {
        return parent;
    }

    public void setParent(BaseEntity parent)
    {
        this.parent = parent;
    }

    public List<BaseEntity> getChildren()
    {
        return children;
    }

    public void setChildren(List<BaseEntity> children)
    {
        this.children = children;
    }
}
