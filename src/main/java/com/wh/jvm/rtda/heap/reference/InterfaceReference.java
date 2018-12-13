package com.wh.jvm.rtda.heap.reference;

import com.wh.jvm.classfile.constantpool.ConstantInterfaceMethodRefInfo;
import com.wh.jvm.rtda.heap.Method;
import com.wh.jvm.rtda.heap.RuntimeConstantPool;

public class InterfaceReference extends MemberReference {
    Method mMethod;


    static public InterfaceReference newInterfaceReference(RuntimeConstantPool pool, ConstantInterfaceMethodRefInfo info){
        InterfaceReference reference = new InterfaceReference();
        reference.mRuntimeConstantPool = pool;
        reference.copyMemberRefInfo(info);

        return reference;
    }

    public Method ResolvedInterfaceMethod(){
        if(mMethod == null){
            resolveInterfaceMethodRef();
        }

        return mMethod;
    }

    public void resolveInterfaceMethodRef(){

        // TODO
    }
}
