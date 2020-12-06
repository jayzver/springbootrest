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
    public String save(MultipartFile file, String directory, String date)
    {
        Path path = Paths.get(ROOT_FOLDER+directory);
        StringBuilder builder = new StringBuilder(Objects.requireNonNull(file.getOriginalFilename()));
        for (int i =  builder.length() - 1; i > 0; i--)
        {
            if (builder.charAt(i) == '.')
            {
                builder.insert(i, date);
                break;
            }
        }
        String name = builder.toString();
        try
        {
            Files.copy(file.getInputStream(), path.resolve(name));
            return name;
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
            return "";
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
