package net.oneqas.services.JPA;

import net.oneqas.entity.BaseEntity;
import net.oneqas.entity.aggregate.Aggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JPA extends JpaRepository<Aggregate, Long>
{
//    void delete(Long id);
//    BaseEntity update(BaseEntity group);
//    void save(BaseEntity group);
//    BaseEntity getById(Long id);
}
