package com.wh.jvm.classloader;

import com.wh.jvm.Utils;
import com.wh.jvm.classloader.entry.ClassLoaderEntry;
import com.wh.jvm.classloader.entry.ClassLoaderEntryFactory;

import java.io.File;
import java.io.FilenameFilter;

public class ClassLoader extends java.lang.ClassLoader{
    private String mJavaHome;
    private String mCpOption;

    private ClassLoaderEntry mBootClassPathEntry;
    private ClassLoaderEntry mExtClassPathEntry;
    private ClassLoaderEntry mUserClassPathEntry;

    public ClassLoader(String cpOption){
        mJavaHome = System.getProperty("java.home");
        mCpOption  = cpOption;
        parseClass();

        System.err.println(System.getProperty("java.home"));
    }

    public ClassLoaderEntry parseClassByPath(String jarPath){

        if(jarPath == null){
            return null;
        }

        return ClassLoaderEntryFactory.newClassPathEntry(jarPath);
    }

    private void parseClass(){

        if(Utils.textIsEmpty(mJavaHome)){
            System.err.println("Java Home is null !!!");
            throw new RuntimeException();
        }

        String jrePath = new StringBuffer(mJavaHome).append("/lib").toString();
        String extPath = new StringBuilder(mJavaHome).append("/lib/ext").toString();
        mBootClassPathEntry = parseClassByPath(getJarFile(jrePath));
        mExtClassPathEntry = parseClassByPath(getJarFile(extPath));
        mUserClassPathEntry = parseClassByPath(mCpOption);
    }

    public byte[] readClass(String classObject){

        String className = classObject.replace(".", "/");
        byte[] bytes = null;
        if(mBootClassPathEntry != null && (bytes = mBootClassPathEntry.readClass(className)) != null){
            return bytes;
        } else if(mExtClassPathEntry != null && (bytes = mExtClassPathEntry.readClass(className)) != null){
            return bytes;
        } else if(mUserClassPathEntry !=null && (bytes = mUserClassPathEntry.readClass(className)) != null) {
            return bytes;
        }

        return bytes;
    }

    private String getJarFile(String path){
        File file = new File(path);
        String[] jarFileList = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("JAR") || name.endsWith("jar");
            }
        });

        StringBuilder builder = new StringBuilder();
        if(jarFileList != null){
            for(int i = 0; i < jarFileList.length; i++){
                builder.append(path+File.separator+jarFileList[i]);

                if(i != jarFileList.length -1){
                    builder.append(File.pathSeparator);
                }
            }
        }

        return builder.toString();
    }

}
