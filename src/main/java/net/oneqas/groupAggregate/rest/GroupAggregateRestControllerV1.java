package net.oneqas.groupAggregate.rest;

import net.oneqas.groupAggregate.model.GroupAggregate;
import net.oneqas.groupAggregate.service.GroupAggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/group_aggregate/")
public class GroupAggregateRestControllerV1
{



    private final GroupAggregateService service;

    public GroupAggregateRestControllerV1(@Autowired GroupAggregateService service)
    {
        this.service = service;
    }

    @RequestMapping(value = "get_groups_by_parent_id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupAggregate>> getGroupsByParentId(@PathVariable("id") Long parentId)
    {
        if (parentId == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<GroupAggregate> groups = service.getGroupsByParentId(parentId);
        if (groups == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<GroupAggregate>>(groups, HttpStatus.OK);
    }


//    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
//            @RequestParam("groupAggregate") Object groupAggregate,

    @CrossOrigin(origins = "")
    @PostMapping()
    public ResponseEntity<Object> saveGroupAggregate(
            @RequestParam("fille") MultipartFile file)
    {
        HttpHeaders headers = new HttpHeaders();
        if (file == null)
        {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
//        this.service.save(group);
        return new ResponseEntity<Object>(file, headers, HttpStatus.CREATED);
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
        GroupAggregate group = this.service.getById(groupId);
        if (group == null)
        {
            return new ResponseEntity<GroupAggregate>(HttpStatus.NOT_FOUND);
        }
        this.service.delete(groupId);
        return new ResponseEntity<GroupAggregate>(HttpStatus.OK);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<GroupAggregate>> getAll()
//    {
//        List<GroupAggregate> oGroups = this.service.getAll();
//        if (oGroups.size() == 0)
//        {
//            return new ResponseEntity<List<GroupAggregate>>(HttpStatus.NOT_FOUND);
//        }
//        List<GroupAggregate> groups = oGroups.subList(0, oGroups.size());
//        return new ResponseEntity<List<GroupAggregate>>(groups, HttpStatus.OK);
//    }
}
