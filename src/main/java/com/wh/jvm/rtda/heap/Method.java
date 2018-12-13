package com.wh.jvm.rtda.heap;

import com.wh.jvm.classfile.MemberAttr;
import com.wh.jvm.classfile.attributeinfo.Code;
import com.wh.jvm.classfile.basictype.U4;

public class Method extends ClassMember{
    public U4 maxStack;
    public U4 maxLocals;
    public byte[] code;

    static  public Method[] newMethods(JClass jClass, MemberAttr[] memberAttrs){

        Method[] methods = new Method[memberAttrs.length];
        for(int i = 0; i < methods.length; i++){
            methods[i].mJClazz = jClass;
            methods[i].copyMemberInfo(memberAttrs[i]);
            methods[i].copyAttributes(memberAttrs[i]);
        }

        return methods;
    }

    public void copyAttributes(MemberAttr memberAttr) {

        Code codeAttr = memberAttr.getCodeAttributes();
        if(codeAttr != null){
            maxStack = new U4(codeAttr.maxStack);
            maxLocals = new U4(codeAttr.maxLocals);
            code = codeAttr.code;
        }
    }

    public boolean isSynchronized(){
        return accessFlags == JClass.AccessFlag.ACC_SYNCHRONIZED.mFlag;
    }

    public boolean isBridge(){
        return  accessFlags == JClass.AccessFlag.ACC_BRIDGE.mFlag;
    }

    public boolean isVarargs(){
        return accessFlags == JClass.AccessFlag.ACC_VARARGS.mFlag;
    }

    public boolean isNative(){
        return accessFlags == JClass.AccessFlag.ACC_NATIVE.mFlag;
    }

    public boolean isAbstract(){
        return accessFlags == JClass.AccessFlag.ACC_ABSTRACT.mFlag;
    }

    public boolean isStrict(){
        return accessFlags == JClass.AccessFlag.ACC_STRICT.mFlag;
    }
}
