package net.oneqas.fileEnviron.FileService;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public interface FileService
{
    static final String GROUP_AGGREGATE_IMAGE = "server/imgs/groupImages/";

    String save(MultipartFile File, String directory, String date);
    File get(String name, String directory);
    boolean delete(String name, String directory);
}
