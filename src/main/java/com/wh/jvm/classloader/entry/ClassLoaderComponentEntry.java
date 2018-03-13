package com.wh.jvm.classloader.entry;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by louie.wang on 2017/12/12.
 */

public class ClassLoaderComponentEntry implements ClassLoaderEntry {

    private String mJarPath;
    private List<ClassLoaderEntry> mEntry;
    public ClassLoaderComponentEntry(String jarPathList) {
        mJarPath = jarPathList;
        mEntry = new ArrayList();
        listPath( );
    }

    @Override
    public byte[] readClass(String className) {
        byte[] bytes = null;
        for (ClassLoaderEntry entry: mEntry) {
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
                mEntry.add(new ClassLoaderZipEntry(f.getAbsolutePath()));
            } else if (f.isDirectory()){
                mEntry.add(new ClassLoaderDirEntry(file));
            }
        }
    }
}
