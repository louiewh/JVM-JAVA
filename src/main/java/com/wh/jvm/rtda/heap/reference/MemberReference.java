package com.wh.jvm.rtda.heap.reference;

import com.wh.jvm.classfile.constantpool.ConstantMemberRefInfo;

public class MemberReference extends SymbolReference{

    public String mName;
    public String mDescriptor;

    public MemberReference copyMemberRefInfo(ConstantMemberRefInfo info){

        return null;
    }
}
