package net.oneqas.proxyEntity;

import net.oneqas.entity.BaseEntity;

import java.util.List;

public abstract class ProxyEntity
{
    protected BaseEntity parent;
    protected List<?> children;

    public ProxyEntity(BaseEntity parent, List<?> children)
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

    public List<?> getChildren()
    {
        return children;
    }

    public void setChildren(List<?> children)
    {
        this.children = children;
    }
}
