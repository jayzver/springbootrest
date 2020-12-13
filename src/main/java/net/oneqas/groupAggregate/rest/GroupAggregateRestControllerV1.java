package net.oneqas.groupAggregate.rest;

import net.oneqas.groupAggregate.model.GroupAggregate;
import net.oneqas.groupAggregate.service.GroupAggregateService;
import net.oneqas.services.FileService.FileService;
import net.oneqas.services.FileService.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/group_aggregate/")
public class GroupAggregateRestControllerV1
{
    private Path path = Paths.get("E:/IdeaProjects/angularRest/src/assets/imgs/server/groupImages");
    private final GroupAggregateService service;
    private final FileService fileService;

    public GroupAggregateRestControllerV1(@Autowired GroupAggregateService service, @Autowired FileService fileService)
    {
        this.service = service;
        this.fileService = fileService;
    }

    @RequestMapping(value = "get_groups_by_parent_id/{id}", method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity<GroupAggregate> saveGroupAggregate(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("groupAggregate") String object)
    {
        String imgName = "";
        if (file != null)
        {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            imgName = this.fileService.save(file, FileServiceImpl.GROUP_AGGREGATE_IMAGE, simpleDateFormat.format(date));
        }
        if (imgName.isEmpty())
        {
            imgName = "noneImg.png";
        }
        GroupAggregate group = GroupAggregate.parseFromJson(object);
        group.setImgUrl(imgName);
        if (group != null)
        {
            this.service.save(group);
            return new ResponseEntity<GroupAggregate>(group, HttpStatus.CREATED);
        } else
        {
            return new ResponseEntity<GroupAggregate>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupAggregate> updateGroupAggregate(@RequestParam(value = "file", required = false) MultipartFile file,
                                                               @RequestParam("groupAggregate") String object)
    {
        GroupAggregate group = GroupAggregate.parseFromJson(object);
        if (group == null)
        {
            return new ResponseEntity<GroupAggregate>(HttpStatus.BAD_REQUEST);
        }
        if (file != null)
        {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String imgName = this.fileService.save(file, FileServiceImpl.GROUP_AGGREGATE_IMAGE, simpleDateFormat.format(date));
            if (imgName.isEmpty())
            {
                imgName = "noneImg.png";
            }
            group.setImgUrl(imgName);
        }
        this.service.update(group);
        return new ResponseEntity<GroupAggregate>(group, HttpStatus.OK);
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
        this.fileService.remove(group.getImgUrl(), FileServiceImpl.GROUP_AGGREGATE_IMAGE);
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
