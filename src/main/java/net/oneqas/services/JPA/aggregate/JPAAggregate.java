package net.oneqas.services.JPA.aggregate;

import net.oneqas.entity.BaseEntity;
import net.oneqas.entity.aggregate.Aggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JPAAggregate extends JpaRepository<Aggregate, Long>
{
    @Query("select a from Aggregate a where a.parentId = ?1")
    BaseEntity getByParentId(Long parentId);
    @Query("select a from Aggregate a where a.groupId = ?1 and a.parentId = 0")
    BaseEntity getFirstByGroupId(Long groupId);
    @Query("select a.id, a.nameTarget, a.parentId, a.groupId, a.description, a.imgUrl from Aggregate a where a.groupId = ?1")
    List<?> getChildrenByGroupId(Long groupId);
    @Query("select a.id, a.nameTarget, a.parentId, a.groupId, a.description, a.imgUrl from Aggregate a where a.parentId = ?1")
    List<?> getChildrenByParentId(Long id);


//    List<String> getPhotosById(Long id);
//    List<String> getFilesById(Long id);
//    List<Provider> getProvidersById(Long id);
//    List<AdditionalProperties> getAdditionalPropertiesById(Long id);
}
