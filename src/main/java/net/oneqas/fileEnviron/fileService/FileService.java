package net.oneqas.fileEnviron.fileService;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public interface FileService
{
    String save(MultipartFile File, String directory, String date);
    File get(String name, String directory);
    boolean delete(String name, String directory);
}
