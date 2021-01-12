package net.oneqas.services.JPA;

import net.oneqas.entity.aggregate.Aggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPA extends JpaRepository<Aggregate, Long>
{
}
