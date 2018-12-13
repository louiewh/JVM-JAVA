package com.wh.jvm.rtda.heap.reference;

import com.wh.jvm.Utils;
import com.wh.jvm.classfile.constantpool.ConstantFieldRefInfo;
import com.wh.jvm.rtda.heap.Field;
import com.wh.jvm.rtda.heap.JClass;
import com.wh.jvm.rtda.heap.RuntimeConstantPool;

public class FieldReference extends MemberReference{
    Field mField;

    static public FieldReference newFieldRef(RuntimeConstantPool pool, ConstantFieldRefInfo info){

        FieldReference reference = new FieldReference();
        reference.mRuntimeConstantPool = pool;
        reference.copyMemberRefInfo(info);

        return reference;
    }

    public Field resolvedField(){
        if(mField == null){
            resolveFieldRef();
        }

        return mField;
    }

    public void resolveFieldRef(){
        Field field = lookupField(resolvedClass(), mName, mDescriptor);

        if(field == null){
            throw new RuntimeException("resolveFieldRef null");
        }

        if(field.isAccessibleTo(mJClass)){
            throw new RuntimeException("resolveFieldRef isAccessibleTo");
        }
    }

    public Field lookupField(JClass jClass, String name, String descriptor){

        for (Field field: jClass.mFieldArray) {
            if(Utils.textEquals(field.mName, name) && Utils.textEquals(field.mDescriptor, mDescriptor)){
                return field;
            }
        }

        for (JClass interfaceJClass:jClass.mInterfaceArray) {
            Field field = lookupField(interfaceJClass, name, descriptor);
            if(field != null){
                return field;
            }
        }

        if(jClass.mSuperClass != null ){
            return lookupField(jClass.mSuperClass, name, descriptor);
        }

        return null;
    }
}
