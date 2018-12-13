package com.wh.jvm.classpath.entry;

/**
 * Created by louie.wang on 2017/12/11.
 */

public interface ClassPathEntry {

    byte[] readClass(String className);

    String toString();
}
