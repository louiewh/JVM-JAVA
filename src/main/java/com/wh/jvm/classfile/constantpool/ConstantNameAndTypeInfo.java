package com.wh.jvm.classfile.constantpool;

import com.wh.jvm.classfile.basictype.U2;
import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantNameAndTypeInfo extends ConstantPoolInfo {

    private U2 nameIndex;
    private U2 descriptorIndex;

    public ConstantNameAndTypeInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 nameIndexU2 = U2.read(inputStream);
        U2 descriptorIndexU2 = U2.read(inputStream);
        this.nameIndex = nameIndexU2;
        this.descriptorIndex = descriptorIndexU2;
    }

    @Override
    public String toString() {
        return "ConstantNameAndTypeInfo{" +
                "nameIndex=" + nameIndex.getValue() +
                ", descriptorIndex=" + descriptorIndex.getValue() +
                '}';
    }

    public U2 getDescriptorIndex() {
        return descriptorIndex;
    }

    public U2 getNameIndex() {
        return nameIndex;
    }
}
