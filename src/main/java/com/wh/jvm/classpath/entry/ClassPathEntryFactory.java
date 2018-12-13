package com.wh.jvm.classpath.entry;


import java.io.File;

/**
 * Created by louie.wang on 2017/12/11.
 */

public class ClassPathEntryFactory {

    static public ClassPathEntry newClassPathEntry(String path){
        if(path.contains(File.pathSeparator)){
            return new ClassPathComponentEntry(path);
        } else if(path.endsWith(".jar") || path.endsWith(".JAR")){
            return new ClassPathZipEntry(path);
        } else if(new File(path).isDirectory()){
            return new ClassPathDirEntry(path);
        }

        return new ClassPathDirEntry(path);
    }
}
