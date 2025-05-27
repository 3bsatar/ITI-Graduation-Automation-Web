package com.swaglabs.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {
    private FileUtils() {
        // Private constructor to prevent instantiation
        super();
    }

    public static File getLatestFile(String folderPath){
        File dir = new File(folderPath);
        File[] files = dir.listFiles();
        if (files == null || files.length==0) {
            Logsutil.warn("Directory does not exist or is not a directory: " + folderPath);
            return null;
        }

        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
    }

    public static void deleteFile(File dirPath) {
        if (dirPath == null || !dirPath.exists()) {
            Logsutil.warn("Directory does not exist: " + dirPath);
            return;
        }

        File[] files = dirPath.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFile(file); // recursive call
                }
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    Logsutil.error("Failed to delete: " + file.getAbsolutePath() + " - " + e.getMessage());
                }
            }
        }

        try {
            Files.delete(dirPath.toPath()); // delete the main directory after its contents
        } catch (IOException e) {
            Logsutil.error("Failed to delete directory: " + dirPath.getAbsolutePath() + " - " + e.getMessage());
        }
    }

}
