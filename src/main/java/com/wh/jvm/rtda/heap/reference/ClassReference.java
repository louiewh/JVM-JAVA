package com.wh.jvm.rtda.heap.reference;

import com.wh.jvm.classfile.constantpool.ConstantClassInfo;
import com.wh.jvm.rtda.heap.RuntimeConstantPool;

public class ClassReference extends SymbolReference {

    public static ClassReference newClassReference(RuntimeConstantPool pool, ConstantClassInfo info){

        ClassReference reference = new ClassReference();
        reference.mRuntimeConstantPool = pool;
        reference.mClassName = pool.mJClass.mClassName;

        return reference;
    }
}
