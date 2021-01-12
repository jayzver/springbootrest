package net.oneqas.services.JPA.GroupAggregate;

import net.oneqas.entity.groupAggregate.GroupAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAGroupAggregate extends JpaRepository<GroupAggregate, Long>
{

}
