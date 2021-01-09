package net.oneqas.aggregate.restController;

import net.oneqas.aggregate.model.Aggregate;
import net.oneqas.commonClasses.proxyEntity.ProxyEntity;
import net.oneqas.commonClasses.services.BaseEntityService;
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
    private final BaseEntityService service;

    public AggregateRestControllerV1(@Qualifier("aggregateServiceImplementation") BaseEntityService servicep)
    {
        this.service = servicep;
    }

    @RequestMapping(value = "{groupId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getOne(@PathVariable(value = "groupId", required = false) Long id)
    {
        Aggregate aggregate;
        if (id == null || id < 1)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(value = "by/{parentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getOneBy(@PathVariable(value = "parentId")Long parentId)
    {

    }
}
