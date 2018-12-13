package com.wh.jvm.classfile.constantpool;

import com.wh.jvm.classfile.basictype.U2;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantInterfaceMethodRefInfo extends ConstantMemberRefInfo {

    public ConstantInterfaceMethodRefInfo(byte tag) {
        super(tag);
    }
}
