package net.oneqas.fileEnviron.FileService;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Component
public class GroupAggregateImgFileServiceImpl extends FileServiceImpl
{
    static
    {
       PATH  = "server/imgs/groupImages/";
    }
}
