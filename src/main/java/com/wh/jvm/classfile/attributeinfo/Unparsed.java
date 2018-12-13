package com.wh.jvm.classfile.attributeinfo;

import com.wh.jvm.classfile.basictype.U4;
import com.wh.jvm.classfile.constantpool.ConstantPool;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenyang li.
 */
public class Unparsed extends BasicAttributeInfo {
    byte[] mInfo;

    public Unparsed(ConstantPool constantPool, short attributeNameIndex) {
        super(constantPool);
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U4 attributeLengthU4 = U4.read(inputStream);
        setAttributeLength(attributeLengthU4.getValue());
        mInfo = new byte[attributeLengthU4.getValue()];
        try {
            inputStream.read(mInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] getInfo(){
        return mInfo;
    }
}
