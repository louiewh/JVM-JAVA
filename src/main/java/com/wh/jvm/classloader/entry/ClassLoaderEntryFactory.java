package com.wh.jvm.classloader.entry;


import java.io.File;

/**
 * Created by louie.wang on 2017/12/11.
 */

public class ClassLoaderEntryFactory {

    static public ClassLoaderEntry newClassPathEntry(String path){
        if(path.contains(File.pathSeparator)){
            return new ClassLoaderComponentEntry(path);
        } else if(path.endsWith(".jar") || path.endsWith(".JAR")){
            return new ClassLoaderZipEntry(path);
        } else if(new File(path).isDirectory()){
            return new ClassLoaderDirEntry(path);
        }

        return new ClassLoaderDirEntry(path);
    }
}
