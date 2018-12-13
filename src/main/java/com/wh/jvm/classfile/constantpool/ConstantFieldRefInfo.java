package com.wh.jvm.classfile.constantpool;

import com.wh.jvm.classfile.basictype.U2;

import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class ConstantFieldRefInfo extends ConstantMemberRefInfo {


    public ConstantFieldRefInfo(byte tag) {
        super(tag);
    }
}
