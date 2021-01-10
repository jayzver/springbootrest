package net.oneqas.aggregate.service;

import net.oneqas.aggregate.model.AdditionalProperties;
import net.oneqas.aggregate.model.Aggregate;
import net.oneqas.aggregate.model.Provider;
import net.oneqas.commonClasses.BaseEntity;
import net.oneqas.commonClasses.services.BaseEntityService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AggregateService extends BaseEntityService
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
