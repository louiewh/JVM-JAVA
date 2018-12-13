package com.wh.jvm.classfile.basictype;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenyangli.
 */
public class U1 {

    private short value;

    public U1(short value) {
        this.value = value;
    }

    public static U1 read(InputStream inputStream) {
        byte[] bytes = new byte[1];
        try {
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        U1 u1 = new U1((short) (bytes[0] & 0xFF));
        return u1;
    }

    public byte getValue() {
        return (byte) value;
    }

    public String getHexValue() {
        return Integer.toHexString(value & 0xFF);
    }
}
