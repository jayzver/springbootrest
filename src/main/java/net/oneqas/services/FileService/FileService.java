package net.oneqas.services.FileService;

import java.io.File;

public interface FileService
{
    boolean save(String directory, File File);
    boolean get(String directory, String name);
}
