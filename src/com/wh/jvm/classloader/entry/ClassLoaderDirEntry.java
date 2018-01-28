package com.wh.jvm.classloader.entry;


import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by louie.wang on 2017/12/11.
 */

public class ClassLoaderDirEntry implements ClassLoaderEntry {
    String mClassFilePath;

    public ClassLoaderDirEntry(String path){
        mClassFilePath = path;
    }

    @Override
    public byte[] readClass(String className) {
            return readByteArray(className);
    }

    @Override
    public String toString() {
        return "ClassPathDirEntry:"+super.toString();
    }


    public byte[] readByteArray(String classname) {

        File file = new File(mClassFilePath+ File.separator+classname+".class");
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file) ;
            System.out.println("file - " + classname + " : " + file.length() + " bytes");

            return  IOUtils.toByteArray(fileInputStream);
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
