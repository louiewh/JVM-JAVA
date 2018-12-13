package com.wh.jvm.classfile.constantpool;


import com.wh.jvm.classfile.basictype.U2;

/**
 * Created by chenyangli.
 */
public class ConstantPool {

    protected U2 constantPoolCount;           // constant_pool_count
    protected ConstantPoolInfo[] cpInfo;      // cp_info


    public ConstantPool(ConstantPoolInfo[] cpInfo) {
        constantPoolCount = new U2((short) cpInfo.length);
        this.cpInfo = cpInfo;
    }

    public ConstantPool(short constantPoolCount) {
        U2 u2 = new U2(constantPoolCount);
        this.constantPoolCount = u2;
        cpInfo = new ConstantPoolInfo[this.constantPoolCount.getValue()];
    }

    public ConstantPoolInfo[] getCpInfo() {
        return cpInfo;
    }


    public void setCpInfo(ConstantPoolInfo[] cpInfo) {
        constantPoolCount = new U2((short) cpInfo.length);
        this.cpInfo = cpInfo;
    }

    public U2 getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(U2 constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    public ConstantPoolInfo getConstantInfo(U2 index){
        ConstantPoolInfo info = cpInfo[index.getValue()];
        if(info != null)  return  info;

        throw new RuntimeException("getConstantInfo Invalid constant pool index");
    }


    public String getNameByNameAndType(U2 index){
        ConstantNameAndTypeInfo info = (ConstantNameAndTypeInfo) getConstantInfo(index);

        return getUtf8String(info.getNameIndex());
    }

    public String getTypeByNameAndType(U2 index){
        ConstantNameAndTypeInfo info = (ConstantNameAndTypeInfo) getConstantInfo(index);

        return getUtf8String(info.getDescriptorIndex());
    }

    public String getClassName(U2 index){
        ConstantClassInfo classInfo = (ConstantClassInfo) getConstantInfo(index);

        return getUtf8String(classInfo.getIndex());
    }

    public String getUtf8String(U2 index){
        ConstantUtf8Info utf8Info = (ConstantUtf8Info) getConstantInfo(index);

        return utf8Info.getValue();
    }
}
