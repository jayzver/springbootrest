package net.oneqas.controllers.aggregateRestController;

import net.oneqas.entity.aggregate.Aggregate;
import net.oneqas.proxyEntity.ProxyEntity;
import net.oneqas.services.DAO.DAO;
import net.oneqas.services.JPA.aggregate.JPAAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/aggregate/")
@CrossOrigin(origins = "http://localhost:4200")
public class AggregateRestControllerV1
{
    private final DAO service;
    private final JPAAggregate jpa;

    public AggregateRestControllerV1(@Qualifier("DAOAggregateImpl") DAO service, JPAAggregate jpa)
    {
        this.service = service;
        this.jpa = jpa;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getOne(@PathVariable(value = "id", required = false) Long id)
    {
        if (id == null || id < 1)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Aggregate aggregate;
        return null;
    }

    @RequestMapping(value = "by/{parentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getOneBy(@PathVariable(value = "parentId")Long parentId)
    {
        if(parentId == null || parentId < 1)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Aggregate aggregate;
        return null;
    }

    @RequestMapping(value = "children/{groupId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getChildren(@PathVariable(value = "groupId")Long groupId)
    {
        if (groupId == null || groupId < 1)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(value = "children/by/{parentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getChildrenBy(@PathVariable(value = "parentId")Long parentId)
    {
        if (parentId == null || parentId < 1)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(value = "{groupId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> save(@RequestParam("aggregate") String object,
                                            @PathVariable(value = "groupId")Long groupId)
    {
        if (groupId == null || groupId < 1)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(value = "by/{parentId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> saveBy(@RequestParam("aggregate")String object,
                                              @PathVariable(value = "parentId")Long parentId)
    {
        if (parentId == null || parentId < 1)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
