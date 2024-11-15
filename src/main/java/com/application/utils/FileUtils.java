package com.application.utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {
    public static void byte2file(String path,byte[] data) {
        try {
            FileOutputStream outputStream  =new FileOutputStream(new File(path));
            outputStream.write(data);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
