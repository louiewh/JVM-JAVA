package com.wh.jvm.rtda;

import com.wh.jvm.rtda.heap.JClass;

public class Jobject {

    private JClass mJClass;
    private Slot mSlot;



    public static Jobject newObject(JClass jClass){
        Jobject jobject = new Jobject();
        jobject.mJClass = jClass;
        jobject.mSlot = new Slot(jClass.getInstanceSlotCountSlot(), null);

        return jobject;
    }


    public JClass getJClass(){
        return mJClass;
    }

    public Slot getSlot(){
        return mSlot;
    }


    // TODO
    public boolean isInstanceOf(JClass jClass){
        return mJClass.equals(jClass);
    }
}
