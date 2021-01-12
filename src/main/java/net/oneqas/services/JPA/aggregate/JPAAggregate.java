package net.oneqas.services.JPA.aggregate;

import net.oneqas.entity.BaseEntity;
import net.oneqas.entity.aggregate.Aggregate;
import net.oneqas.services.JPA.JPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JPAAggregate extends JPA
{
    @Query("select a from Aggregate a where a.parentId = ?1")
    BaseEntity getByParentId(Long parentId);
    @Query("select a from Aggregate a where a.groupId = ?1 and a.parentId = 0")
    BaseEntity getFirst(Long groupId);
    @Query("select a from Aggregate a where a.groupId = ?1")
    List<?> getChildFirst(Long groupId);
    @Query("select a from Aggregate a where a.parentId = ?1")
    List<?> getChildById(Long id);

//    List<String> getPhotosById(Long id);
//    List<String> getFilesById(Long id);
//    List<Provider> getProvidersById(Long id);
//    List<AdditionalProperties> getAdditionalPropertiesById(Long id);
}
