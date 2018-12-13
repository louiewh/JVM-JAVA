package com.wh.jvm.classpath.entry;

import com.wh.jvm.Utils;
import org.apache.commons.io.IOUtils;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by louie.wang on 2017/12/12.
 */

public class ClassPathZipEntry implements ClassPathEntry {
    private String mJarPath;

    public ClassPathZipEntry(String jarPath){
        mJarPath = jarPath;
    }


    public byte[] readClass(String className) {
        return readClassFromJar(className);
    }

    byte[] readClassFromJar(String className){
        try {
            ZipFile zipFile = new ZipFile(mJarPath);
            InputStream in = new BufferedInputStream(new FileInputStream(mJarPath));
            ZipInputStream zipInputStream = new ZipInputStream(in);
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
//                System.err.println("file - " + zipEntry.getName() + " : " + zipEntry.getSize() + " bytes");

                if (zipEntry.isDirectory()) {
                    // System.out.print("directory - " + ze.getName() + " : "+ ze.getSize() + " bytes");
                    // System.out.println();
                } else if (Utils.textEquals(zipEntry.getName(), className+".class")) {
                    System.out.println("file - " + zipEntry.getName() + " : " + zipEntry.getSize() + " bytes");

                    return IOUtils.toByteArray(zipFile.getInputStream(zipEntry));
                }
            }
            zipInputStream.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
