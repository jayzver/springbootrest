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
public class FileServiceImpl implements FileService
{
    private static String ROOT_FOLDER = "";

    static
    {
        String path = (new File(".")).getAbsolutePath().toString();
        StringBuilder builder = new StringBuilder(path);
        int startIndex = 0;
        for (int i = builder.length() - 1, b = 0; i >= 0; i--)
        {
            if (builder.charAt(i) == '\\')
            {
                b++;
                if (b == 2)
                {
                    startIndex = i;
                }
                builder.setCharAt(i, '/');
            }
        }
        builder.delete(startIndex + 1, builder.length());
        ROOT_FOLDER = builder.toString() + "angularRest/src/assets/data/";
        System.out.println(ROOT_FOLDER);
    }

    @Override
    public String save(MultipartFile file, String directory, String date)
    {
        Path path = Paths.get(ROOT_FOLDER + directory);
        StringBuilder builder = new StringBuilder(Objects.requireNonNull(file.getOriginalFilename()));
        for (int i = builder.length() - 1; i > 0; i--)
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
    public File get(String name, String directory)
    {
        return null;
    }

    @Override
    public boolean delete(String name, String directory)
    {
        if (!name.contentEquals("noneImg.png") || !name.isEmpty())
        {
            try
            {
                Files.deleteIfExists(Paths.get(ROOT_FOLDER + directory + name));
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }
}
