package net.oneqas.proxyEntity.groupAggregate;

import net.oneqas.entity.BaseEntity;
import net.oneqas.entity.groupAggregate.GroupAggregate;
import net.oneqas.proxyEntity.ProxyEntity;

import java.util.List;

public class ProxyGroupAggregateImpl extends ProxyEntity
{
    public ProxyGroupAggregateImpl(BaseEntity parent, List<GroupAggregate> children)
    {
        super(parent, children);
    }
}
