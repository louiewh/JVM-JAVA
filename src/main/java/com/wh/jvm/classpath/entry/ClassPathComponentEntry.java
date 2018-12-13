package com.wh.jvm.classpath.entry;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by louie.wang on 2017/12/12.
 */

public class ClassPathComponentEntry implements ClassPathEntry {

    private String mJarPath;
    private List<ClassPathEntry> mEntry;
    public ClassPathComponentEntry(String jarPathList) {
        mJarPath = jarPathList;
        mEntry = new ArrayList();
        listPath( );
    }

    public byte[] readClass(String className) {
        byte[] bytes = null;
        for (ClassPathEntry entry: mEntry) {
            bytes = entry.readClass(className);
            if(bytes != null){
                return bytes;
            }
        }

        return  bytes;
    }

    public void listPath( ) {
        String files[] = mJarPath.split(File.pathSeparator);

        for (String file : files) {
            File f = new File(file);

            if (f.isFile() && (file.endsWith(".jar") || file.endsWith(".JAR"))) {
                mEntry.add(new ClassPathZipEntry(f.getAbsolutePath()));
            } else if (f.isDirectory()){
                mEntry.add(new ClassPathDirEntry(file));
            }
        }
    }
}
