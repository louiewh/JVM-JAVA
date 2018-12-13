package com.wh.jvm.rtda.heap.reference;

import com.wh.jvm.rtda.heap.JClass;
import com.wh.jvm.rtda.heap.RuntimeConstantPool;

public class SymbolReference {

    RuntimeConstantPool mRuntimeConstantPool;
    JClass mJClass;
    String mClassName;


    public JClass resolvedClass(){
        if(mJClass == null){
            return resolveClassRef();
        }


        return mJClass;
    }

    public JClass resolveClassRef(){
        JClass jClass = mRuntimeConstantPool.mJClass.mClassLoader.loadClass(mClassName);
        if(! jClass.isAccessibleTo(mJClass)){
            throw new RuntimeException("java.lang.IllegalAccessError");
        }

        mJClass = jClass;

        return mJClass;
    }
}
