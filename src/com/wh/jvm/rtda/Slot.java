package com.wh.jvm.rtda;

public class Slot {
    long mNumber;
    Jobject  mJobject;

    public Slot(long value, Jobject o) {
        mNumber = value;
        mJobject = o;
    }
}
