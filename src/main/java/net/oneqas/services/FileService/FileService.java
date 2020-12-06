package net.oneqas.services.FileService;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public interface FileService
{
    String save(MultipartFile File, String directory, String date);
    boolean get(String name, String directory);
    File remove(String name, String directory);
}
