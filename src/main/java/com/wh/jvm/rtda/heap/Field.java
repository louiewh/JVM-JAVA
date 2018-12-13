package com.wh.jvm.rtda.heap;

import com.wh.jvm.Utils;
import com.wh.jvm.classfile.FieldInfo;
import com.wh.jvm.classfile.MemberAttr;
import com.wh.jvm.classfile.attributeinfo.ConstantValue;
import com.wh.jvm.classfile.basictype.U4;

public class Field extends ClassMember {

    U4 mConstValueIndex;
    U4 mSlotId;

    static public Field[] newFields(JClass jClass, FieldInfo[] fieldInfos){
        Field[] fieldArray = new Field[fieldInfos.length];
        for(int i = 0; i < fieldInfos.length; i++){
            fieldArray[i].mJClazz = jClass;
            fieldArray[i].copyMemberInfo(fieldInfos[i]);
            fieldArray[i].copyAttributes(fieldInfos[i]);
        }

        return fieldArray;

    }

    public void copyAttributes(MemberAttr memberAttr) {
        ConstantValue constantValue = memberAttr.getConstantValueAttribute();
        if(constantValue != null){
            mConstValueIndex = new U4(constantValue.getAttributeNameIndex());
        }
    }

    public boolean isVolatile(){
        return accessFlags == JClass.AccessFlag.ACC_VOLATILE.mFlag;
    }

    public boolean isTransient(){
        return accessFlags == JClass.AccessFlag.ACC_TRANSIENT.mFlag;
    }

    public boolean isEnum(){
        return accessFlags == JClass.AccessFlag.ACC_ENUM.mFlag;
    }

    public U4 getConstValueIndex(){
        return mConstValueIndex;
    }

    public U4 getSlotId(){
        return mSlotId;
    }

    public boolean isLongOrDouble(){
        return Utils.textEquals(mDescriptor, "J")
                || Utils.textEquals(mDescriptor, "D");
    }
}
