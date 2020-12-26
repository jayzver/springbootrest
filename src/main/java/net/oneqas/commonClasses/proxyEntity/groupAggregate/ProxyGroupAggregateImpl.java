package net.oneqas.commonClasses.proxyEntity.groupAggregate;

import net.oneqas.groupAggregate.model.GroupAggregate;

import java.util.List;

public class ProxyGroupAggregateImpl
{
    private GroupAggregate parent;
    private List<GroupAggregate> children;
    public ProxyGroupAggregateImpl(GroupAggregate parent, List<GroupAggregate> children)
    {
        this.parent = parent;
        this.children = children;
    }

    public GroupAggregate getParent()
    {
        return parent;
    }

    public void setParent(GroupAggregate parent)
    {
        this.parent = parent;
    }

    public List<GroupAggregate> getChildren()
    {
        return children;
    }

    public void setChildren(List<GroupAggregate> children)
    {
        this.children = children;
    }
}
