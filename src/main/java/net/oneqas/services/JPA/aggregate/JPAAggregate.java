package net.oneqas.services.JPA.aggregate;

import net.oneqas.entity.aggregate.Aggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAAggregate extends JpaRepository<Aggregate, Long>
{
}
