package net.oneqas.commonClasses.proxyEntity.aggregate;

import net.oneqas.commonClasses.BaseEntity;
import net.oneqas.commonClasses.proxyEntity.ProxyEntity;

import java.util.List;

public class ProxyAggregateImpl extends ProxyEntity
{
    public ProxyAggregateImpl(BaseEntity parent, List<?> children)
    {
        super(parent, children);
    }
}
