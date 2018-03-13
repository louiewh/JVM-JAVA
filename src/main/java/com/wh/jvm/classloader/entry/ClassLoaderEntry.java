package com.wh.jvm.classloader.entry;

/**
 * Created by louie.wang on 2017/12/11.
 */

public interface ClassLoaderEntry {

    byte[] readClass(String className);

    String toString();
}
