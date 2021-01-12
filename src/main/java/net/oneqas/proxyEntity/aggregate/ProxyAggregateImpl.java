package net.oneqas.proxyEntity.aggregate;

import net.oneqas.entity.BaseEntity;
import net.oneqas.proxyEntity.ProxyEntity;

import java.util.List;

public class ProxyAggregateImpl extends ProxyEntity
{
    public ProxyAggregateImpl(BaseEntity parent, List<?> children)
    {
        super(parent, children);
    }
}
