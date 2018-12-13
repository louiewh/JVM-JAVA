package com.wh.jvm.classfile.constantpool;

import com.wh.jvm.classfile.basictype.U2;
import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantStringInfo extends ConstantPoolInfo {

    private U2 index;

    public ConstantStringInfo(byte tag) {
        setTag(tag);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 indexU2 = U2.read(inputStream);
        this.index = indexU2;
    }

    @Override
    public String toString() {
        return "ConstantStringInfo{" +
                "index=" + index +
                '}';
    }

    public U2 getIndex() {
        return index;
    }
}
