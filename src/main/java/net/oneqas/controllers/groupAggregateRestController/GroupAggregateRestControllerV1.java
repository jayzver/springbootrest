package net.oneqas.controllers.groupAggregateRestController;

import net.oneqas.proxyEntity.ProxyEntity;
import net.oneqas.fileEnviron.fileService.GroupAggregateImgFileServiceImpl;
import net.oneqas.entity.groupAggregate.GroupAggregate;
import net.oneqas.fileEnviron.fileService.FileService;
import net.oneqas.proxyEntity.groupAggregate.ProxyGroupAggregateImpl;
import net.oneqas.services.DAO.groupAggregate.DAOGroupAggregate;
import net.oneqas.services.DAO.groupAggregate.DAOGroupAggregateImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/group_aggregate/")
public class GroupAggregateRestControllerV1
{
    private final DAOGroupAggregate service;
    private final FileService fileService;

    public GroupAggregateRestControllerV1(
            @Qualifier("DAOGroupAggregateImp") @Autowired DAOGroupAggregate service,
            @Autowired FileService fileService)
    {
        this.service = service;
        this.fileService = fileService;
    }
    @RequestMapping(value = {"", "/{id}"}, method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> getGroupsByParentId(@PathVariable(value = "id", required = false) Long id)
    {
        GroupAggregate parent;
        if (id == null || id < 1)
        {
            parent = DAOGroupAggregateImp.setDefault((new GroupAggregate()));
        }
        else
        {
            parent = (GroupAggregate) this.service.getById(id);
        }
        List<?> children = service.getByParentId(parent.getId());
        ProxyEntity proxyEntity = new ProxyGroupAggregateImpl(parent, children);
        return new ResponseEntity<ProxyEntity>(proxyEntity, HttpStatus.OK);
    }


    //    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
//            @RequestParam("groupAggregate") Object groupAggregate,
    @PostMapping(value = "/{parentId}")
    public ResponseEntity<ProxyEntity> saveGroupAggregate(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("groupAggregate") String object, @PathVariable Long parentId)
    {
        if (parentId == null)
        {
            return new ResponseEntity<ProxyEntity>(HttpStatus.BAD_REQUEST);
        }
        String imgName = "";
        if (file != null)
        {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            imgName = this.fileService.save(file, GroupAggregateImgFileServiceImpl.PATH, simpleDateFormat.format(date));
        }
        if (imgName.isEmpty())
        {
            imgName = "noneImg.png";
        }
        GroupAggregate group = DAOGroupAggregateImp.parseFromJson(object);
        if (group != null)
        {
            group.setParentId(parentId);
            group.setImgUrl(imgName);
            this.service.save(group);
            ProxyEntity proxyEntity = new ProxyGroupAggregateImpl(group, null);
            return new ResponseEntity<ProxyEntity>(proxyEntity, HttpStatus.CREATED);
        } else
        {
            return new ResponseEntity<ProxyEntity>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> updateGroupAggregate(@RequestParam(value = "file", required = false) MultipartFile file,
                                                               @RequestParam("groupAggregate") String object)
    {
        GroupAggregate group = DAOGroupAggregateImp.parseFromJson(object);
        if (group == null)
        {
            return new ResponseEntity<ProxyEntity>(HttpStatus.BAD_REQUEST);
        }
        if (file != null)
        {
            this.fileService.delete(group.getImgUrl(), GroupAggregateImgFileServiceImpl.PATH);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String imgName = this.fileService.save(file, GroupAggregateImgFileServiceImpl.PATH, simpleDateFormat.format(date));
            imgName = (!imgName.isEmpty()) ? imgName : "noneImg.png";
            group.setImgUrl(imgName);
        }
        else
        {
            String img = group.getImgUrl();
            img = (!img.isEmpty()) ? img : "noneImg.png";
            group.setImgUrl(img);
        }
        this.service.update(group);
        ProxyEntity proxyEntity = new ProxyGroupAggregateImpl(group, null);
        return new ResponseEntity<ProxyEntity>(proxyEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProxyEntity> deleteGroupAggregate(@PathVariable("id") Long groupId)
    {
        GroupAggregate group = (GroupAggregate)this.service.getById(groupId);
        if (group == null)
        {
            return new ResponseEntity<ProxyEntity>(HttpStatus.NOT_FOUND);
        }
        this.service.delete(groupId);
        this.fileService.delete(group.getImgUrl(), GroupAggregateImgFileServiceImpl.PATH);
        ProxyEntity proxyEntity = new ProxyGroupAggregateImpl(group, null);
        return new ResponseEntity<ProxyEntity>(proxyEntity, HttpStatus.OK);
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
