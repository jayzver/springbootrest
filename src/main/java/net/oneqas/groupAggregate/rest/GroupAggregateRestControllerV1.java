package net.oneqas.groupAggregate.rest;

import net.oneqas.groupAggregate.model.GroupAggregate;
import net.oneqas.groupAggregate.service.GroupAggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/groupaggregate/v1/")
public class GroupAggregateRestControllerV1
{
    private final GroupAggregateService service;

    public GroupAggregateRestControllerV1(@Autowired GroupAggregateService service)
    {
        this.service = service;
    }
    @RequestMapping(value="{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupAggregate> getGroupAggregate(@PathVariable("id") Long groupId)
    {
        if (groupId == null)
        {
            return new ResponseEntity<GroupAggregate>(HttpStatus.BAD_REQUEST);
        }
        GroupAggregate group = this.service.getById(groupId).get();
        if (group == null)
        {
            return new ResponseEntity<GroupAggregate>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<GroupAggregate>(group, HttpStatus.OK);
    }
    @RequestMapping(value="child/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupAggregate>> getC(@PathVariable("id") Long groupId)
    {
        List<GroupAggregate> group = this.service.getChild(groupId);
        return new ResponseEntity<List<GroupAggregate>>(group, HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupAggregate> saveGroupAggregate(@RequestBody GroupAggregate group)
    {
        HttpHeaders headers = new HttpHeaders();
        if (group == null)
        {
            return new ResponseEntity<GroupAggregate>(HttpStatus.BAD_REQUEST);
        }
        this.service.save(group);
        return new ResponseEntity<GroupAggregate>(group, headers, HttpStatus.CREATED);
    }
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupAggregate> updateGroupAggregate(@RequestBody GroupAggregate group, UriComponentsBuilder builder)
    {
        HttpHeaders headers = new HttpHeaders();
        if (group == null)
        {
            return new ResponseEntity<GroupAggregate>(HttpStatus.BAD_REQUEST);
        }
        this.service.save(group);
        return new ResponseEntity<GroupAggregate>(group, headers, HttpStatus.OK);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupAggregate> deleteGroupAggregate(@PathVariable("id") Long groupId)
    {
        GroupAggregate group = this.service.getById(groupId).get();
        if (group == null)
        {
            return new ResponseEntity<GroupAggregate>(HttpStatus.NOT_FOUND);
        }
        this.service.delete(groupId);
        return new ResponseEntity<GroupAggregate>(HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupAggregate>> getAll()
    {
        List<GroupAggregate> oGroups = this.service.getAll();
        if (oGroups.size() == 0)
        {
            return new ResponseEntity<List<GroupAggregate>>(HttpStatus.NOT_FOUND);
        }
        List<GroupAggregate> groups = oGroups.subList(0, oGroups.size());
        return new ResponseEntity<List<GroupAggregate>>(groups, HttpStatus.OK);
    }
}
