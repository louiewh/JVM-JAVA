package com.wh.jvm.classfile;


import com.wh.jvm.classfile.attributeinfo.BasicAttributeInfo;
import com.wh.jvm.classfile.basictype.U2;
import com.wh.jvm.classfile.basictype.U4;
import com.wh.jvm.classfile.constantpool.ConstantClassInfo;
import com.wh.jvm.classfile.constantpool.ConstantPool;
import com.wh.jvm.classfile.constantpool.ConstantPoolInfo;
import com.wh.jvm.classfile.constantpool.ConstantUtf8Info;

/**
 * Created by chenyangli.
 */
public class ClassFile {

    public U4 magic;                            // magic
    public U2 minorVersion;                     // minor_version
    public U2 majorVersion;                     // major_version
    public U2 constantPoolCount;                // constant_pool_count
    public ConstantPoolInfo[] cpInfo;           // cp_info
    public ConstantPool mConstantPool;
    public U2 accessFlags;                      // access_flags
    public U2 thisClass;                        // this_class
    public U2 superClass;                       // super_class
    public U2 interfacesCount;                  // interfaces_count
    public U2[] interfaces;                     // interfaces
    public U2 fieldsCount;                      // fields_count
    public FieldInfo[] fields;                  // fields
    public U2 methodsCount;                     // methods_count
    public MethodInfo[] methods;                // methods
    public U2 attributesCount;                  // attributes_count
    public BasicAttributeInfo[] attributes;     // attributes

    public int getMinorVersion(){
        return minorVersion.getValue();
    }

    public int getMajorVersion(){
        return minorVersion.getValue();
    }

    public ConstantPool getConstantPool(){
        return mConstantPool;
    }

    public U2 getAccessFlags(){
        return accessFlags;
    }

    public FieldInfo[] getFieldInfo(){

        return fields;
    }

    public MethodInfo[] getMethodInfo(){

        return methods;
    }


    public String getClassName(){


        return mConstantPool.getClassName(superClass);
    }


    public String getSuperClassName(){
        if(superClass.getValue() > 0){
            return mConstantPool.getClassName(superClass);
        }

        return null;
    }


    public String[] getInterfaceNames(){
        String[] interfaceArray = new String[interfacesCount.getValue()];
        for(int i = 0; i < interfacesCount.getValue(); i++){
            U2 index = interfaces[i];
            interfaceArray[i] = mConstantPool.getClassName(index);
        }

        return interfaceArray;

    }
}
