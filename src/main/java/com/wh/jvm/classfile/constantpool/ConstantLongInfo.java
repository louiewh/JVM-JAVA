package com.wh.jvm.classfile.constantpool;

import com.wh.jvm.classfile.basictype.U8;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantLongInfo extends ConstantPoolInfo {

    private long bytesValue;

    public ConstantLongInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U8 bytesValueU8 = U8.read(inputStream);
        this.bytesValue = bytesValueU8.getValue();
    }

    @Override
    public String toString() {
        return "ConstantLongInfo{" +
                "bytesValue=" + bytesValue +
                '}';
    }

    public long getBytesValue(){
        return bytesValue;
    }
}
