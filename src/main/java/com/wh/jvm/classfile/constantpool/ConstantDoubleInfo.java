package com.wh.jvm.classfile.constantpool;


import com.wh.jvm.classfile.basictype.U8;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantDoubleInfo extends ConstantPoolInfo {

    private double bytesValue;

    public ConstantDoubleInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U8 bytesValuesU8 = U8.read(inputStream);
        this.bytesValue = bytesValuesU8.getValue();
    }

    @Override
    public String toString() {
        return "ConstantDoubleInfo{" +
                "bytesValue=" + bytesValue +
                '}';
    }

    public double getBytesValue() {
        return bytesValue;
    }
}
