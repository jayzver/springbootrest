package net.oneqas.controllers.aggregateRestController;

import net.oneqas.entity.BaseEntity;
import net.oneqas.entity.aggregate.Aggregate;
import net.oneqas.fileEnviron.fileService.FileService;
import net.oneqas.proxyEntity.ProxyEntity;
import net.oneqas.proxyEntity.aggregate.ProxyAggregateImpl;
import net.oneqas.services.DAO.aggregate.DAOAggregate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aggregate/")
@CrossOrigin(origins = "http://localhost:4200")
public class AggregateRestControllerV1
{
    private final DAOAggregate dao;
    private final FileService fileService;

    public AggregateRestControllerV1(DAOAggregate dao, FileService fileService)
    {
        this.dao = dao;
        this.fileService = fileService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getOne(@PathVariable(value = "id", required = false) Long id)
    {
        if (id == null || id < 1)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Aggregate aggregate = (Aggregate) this.dao.getById(id);
        if (aggregate == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Aggregate g = new Aggregate();
        ProxyEntity data = new ProxyAggregateImpl(aggregate, null);
        return new ResponseEntity<ProxyEntity>(data, HttpStatus.OK);
    }

    @RequestMapping(value = "by/{parentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getOneBy(@PathVariable(value = "parentId")Long parentId)
    {
        if(parentId == null || parentId < 1)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Aggregate aggregate = (Aggregate) this.dao.getByParentId(parentId);
        if (aggregate == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProxyEntity data = new ProxyAggregateImpl(aggregate, null);
        return new ResponseEntity<ProxyEntity>(data, HttpStatus.OK);
    }

    @RequestMapping(value = "children/{groupId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getChildren(@PathVariable(value = "groupId")Long groupId)
    {
        if (groupId == null || groupId < 1)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<?> childrenByGroupId = this.dao.getChildrenByGroupId(groupId);
        if (childrenByGroupId == null || childrenByGroupId.size() == 0)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProxyEntity data = new ProxyAggregateImpl(null, childrenByGroupId);
        return new ResponseEntity<ProxyEntity>(data, HttpStatus.OK);
    }

    @RequestMapping(value = "children/by/{parentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getChildrenBy(@PathVariable(value = "parentId")Long parentId)
    {
        if (parentId == null || parentId < 1)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<?> childrenByParentId = this.dao.getChildrenByParentId(parentId);
        if (childrenByParentId == null || childrenByParentId.size() == 0)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BaseEntity aggregate = this.dao.getById(parentId);
        ProxyEntity data = new ProxyAggregateImpl(aggregate, childrenByParentId);
        return new ResponseEntity<ProxyEntity>(data, HttpStatus.OK);
    }

    @RequestMapping(value = "{groupId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> save(@RequestParam("aggregate") String object,
                                            @PathVariable(value = "groupId")Long groupId)
    {
        if (groupId == null || groupId < 1)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @RequestMapping(value = "by/{parentId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> saveBy(@RequestParam("aggregate")String object,
                                              @PathVariable(value = "parentId")Long parentId)
    {
        if (parentId == null || parentId < 1)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> update(@RequestParam("aggregate")String object)
    {
        return null;
    }

    @RequestMapping(value = "{parentId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> delete(@PathVariable(value = "parentId")Long parentId)
    {
        if (parentId == null || parentId < 1)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
