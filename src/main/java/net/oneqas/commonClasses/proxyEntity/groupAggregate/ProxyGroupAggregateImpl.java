package net.oneqas.commonClasses.proxyEntity.groupAggregate;

import net.oneqas.commonClasses.BaseEntity;
import net.oneqas.commonClasses.proxyEntity.ProxyEntity;
import net.oneqas.groupAggregate.model.GroupAggregate;

import java.util.List;

public class ProxyGroupAggregateImpl extends ProxyEntity
{
    public ProxyGroupAggregateImpl(BaseEntity parent, List<?> children)
    {
        super(parent, children);
    }
}
