package com.wh.jvm.classfile.constantpool;


import com.wh.jvm.classfile.basictype.U2;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantMemberRefInfo extends ConstantPoolInfo {

    protected short classIndex;
    protected short nameAndTypeIndex;

    public ConstantMemberRefInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 classIndexU2 = U2.read(inputStream);
        U2 nameAndTypeIndexU2 = U2.read(inputStream);
        this.classIndex = classIndexU2.getValue();
        this.nameAndTypeIndex = nameAndTypeIndexU2.getValue();
    }

    @Override
    public String toString() {
        return "ConstantMethodRefInfo{" +
                "classIndex=" + classIndex +
                ", nameAndTypeIndex=" + nameAndTypeIndex +
                '}';
    }
}
