package net.oneqas.services.FileService;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Component
public class FileServiceImpl implements FileService
{
    private static final String ROOT_FOLDER = "E:/IdeaProjects/angularRest/src/assets/data/";
    public static final String GROUP_AGGREGATE_IMAGE = "server/imgs/groupImages/";

    @Override
    public boolean save(MultipartFile file, String directory)
    {
        Path path = Paths.get(ROOT_FOLDER+directory);
        try
        {
            Files.copy(file.getInputStream(), path.resolve(Objects.requireNonNull(file.getOriginalFilename())));
            return true;
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean get(String name, String directory)
    {
        return false;
    }

    @Override
    public File remove(String name, String directory)
    {
        return null;
    }
}
