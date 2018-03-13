package com.wh.jvm.instruction;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class CodeReader {

    private byte[] mCode;
    private int mPC;
    DataInputStream mCodeStream;

    public void reset(byte[] code, int pc){

        mCode = code;
        mPC = pc;
        mCodeStream = new DataInputStream(new ByteArrayInputStream(mCode));
    }

    public int getPC(){
        return mPC;
    }

    public int readUint8(){
        try {
            int i = mCodeStream.readUnsignedByte();
            mPC ++;
            return i;
        } catch (IOException e) {
            e.printStackTrace();
            throw new  RuntimeException();
        }
    }

    public int readInt8(){
        try {
            int i = mCodeStream.readByte();
            mPC ++;

            return i;
        } catch (IOException e) {
            e.printStackTrace();

            throw new RuntimeException();
        }
    }

    public int readUint16(){

        try {
            mPC ++;
            mPC ++;

            return mCodeStream.readUnsignedShort();
        } catch (IOException e) {
            e.printStackTrace();

            throw new RuntimeException();
        }
    }

    public int readInt16(){

        try {
            mPC ++;
            mPC ++;

            return mCodeStream.readShort();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int readInt32(){

        try {
            mPC ++;
            mPC ++;
            mPC ++;
            mPC ++;

            return mCodeStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    // used by lookupswitch and tableswitch
    public int[] readInt32s(int len){

        int[] result = new int[len];

        for (int i = 0; i< len; i++){
            result[i] = readInt32();
        }

        return result;
    }

    // used by lookupswitch and tableswitch
    public void skipPadding(){

        while(mPC % 4 != 0){
            mPC ++;
        }
    }

}
