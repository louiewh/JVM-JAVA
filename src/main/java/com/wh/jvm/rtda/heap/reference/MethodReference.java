package com.wh.jvm.rtda.heap.reference;

import com.wh.jvm.classfile.constantpool.ConstantMemberRefInfo;
import com.wh.jvm.rtda.heap.Method;
import com.wh.jvm.rtda.heap.RuntimeConstantPool;

public class MethodReference extends MemberReference {

    Method mMethod;


    static public MethodReference newInterfaceReference(RuntimeConstantPool pool, ConstantMemberRefInfo info){
        MethodReference reference = new MethodReference();
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
