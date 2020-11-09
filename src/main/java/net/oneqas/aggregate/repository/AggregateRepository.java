package net.oneqas.aggregate.repository;

import net.oneqas.aggregate.model.Aggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AggregateRepository extends JpaRepository<Aggregate, Long>
{
}
