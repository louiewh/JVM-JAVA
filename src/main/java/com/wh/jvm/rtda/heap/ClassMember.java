package com.wh.jvm.rtda.heap;

import com.wh.jvm.Utils;
import com.wh.jvm.classfile.MemberAttr;

public abstract class ClassMember {

    public  int   accessFlags;
    public String mName;
    public String mDescriptor;
    public String mSignature;
    public byte[] mAnnotationData;  // RuntimeVisibleAnnotations_attribute
    public JClass mJClazz;


    public void copyMemberInfo(MemberAttr memberAttr){
        this.accessFlags = memberAttr.accessFlags;
        this.mName = memberAttr.getName();
        this.mDescriptor = memberAttr.getDescriptor();
    }

    abstract public void copyAttributes(MemberAttr memberAttr);

    public boolean isPublic(){

        return accessFlags == JClass.AccessFlag.ACC_PUBLIC.mFlag;
    }

    public boolean isPrivate(){

        return accessFlags == JClass.AccessFlag.ACC_PRIVATE.mFlag;
    }

    public boolean isProtected(){

        return accessFlags == JClass.AccessFlag.ACC_PROTECTED.mFlag;
    }

    public boolean isIsStatic(){

        return accessFlags == JClass.AccessFlag.ACC_STATIC.mFlag;
    }


    public boolean isFinal(){

        return accessFlags == JClass.AccessFlag.ACC_FINAL.mFlag;
    }


    public boolean isSynthetic(){

        return accessFlags == JClass.AccessFlag.ACC_SYNTHETIC.mFlag;
    }


    public boolean isAccessibleTo(JClass jClass){
        if(isPublic()){
            return true;
        } else if(isProtected()){

            // TODO
            return this.equals(jClass)
                    || Utils.textEquals(mJClazz.getPackageName(), jClass.getPackageName());

        } else if(isPrivate()){

            return Utils.textEquals(mJClazz.getPackageName(), jClass.getPackageName());
        }

        return true;
    }
}
