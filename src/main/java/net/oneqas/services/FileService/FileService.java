package net.oneqas.services.FileService;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public interface FileService
{
    boolean save(MultipartFile File, String directory);
    boolean get(String name, String directory);
    File remove(String name, String directory);
}
