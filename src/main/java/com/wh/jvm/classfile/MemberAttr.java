package com.wh.jvm.classfile;

import com.wh.jvm.Utils;
import com.wh.jvm.classfile.attributeinfo.*;
import com.wh.jvm.classfile.basictype.U2;
import com.wh.jvm.classfile.constantpool.ConstantPool;

import java.io.InputStream;

public class MemberAttr {

    public ConstantPool constantPool;

    public int accessFlags;
    public int nameIndex;
    public int descriptorIndex;
    public int attributesCount;
    public BasicAttributeInfo[] attributes;


    public void read(InputStream inputStream) {
        U2 accessFlagsU2 = U2.read(inputStream);
        U2 nameIndexU2 = U2.read(inputStream);
        U2 descriptorIndexU2 = U2.read(inputStream);
        U2 attributesCountIndexU2 = U2.read(inputStream);
        accessFlags = accessFlagsU2.getValue();
        nameIndex = nameIndexU2.getValue();
        descriptorIndex = descriptorIndexU2.getValue();
        attributesCount = attributesCountIndexU2.getValue();
        attributes = new BasicAttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            U2 attributeNameIndexU2 = U2.read(inputStream);
            short attributeNameIndex = attributeNameIndexU2.getValue();
            BasicAttributeInfo basicAttributeInfo = BasicAttributeInfo.newAttributeInfo(constantPool, attributeNameIndex);
            basicAttributeInfo.read(inputStream);
            attributes[i] = basicAttributeInfo;
        }
    }

    public int getAccessFlags(){
        return  accessFlags;
    }

    public String getName(){
        return constantPool.getUtf8String(new U2((short) nameIndex));
    }

    public String getDescriptor(){
        return constantPool.getUtf8String(new U2((short) descriptorIndex));
    }

    public Code getCodeAttributes() {
        for(int i = 0; i < attributes.length; i++){

            if(attributes[i] instanceof Code){
                return (Code) attributes[i];
            }
        }

        return null;
    }

    public ConstantValue getConstantValueAttribute(){
        for(int i = 0; i < attributes.length; i++){

            if(attributes[i] instanceof ConstantValue){
                return (ConstantValue) attributes[i];
            }
        }

        return null;
    }

    public Exceptions getExceptionsAttribute(){
        for(int i = 0; i < attributes.length; i++){

            if(attributes[i] instanceof Exceptions){
                return (Exceptions) attributes[i];
            }
        }

        return null;
    }


    public byte[] getRuntimeVisibleAnnotationsAttributeData(){

        return getUnparsedAttributeData("RuntimeVisibleAnnotations");

    }

    public byte[] getRuntimeVisibleParameterAnnotationsAttributeData(){

        return getUnparsedAttributeData("RuntimeVisibleParameterAnnotationsAttribute");

    }

    public byte[] getAnnotationDefaultAttributeData(){

        return getUnparsedAttributeData("AnnotationDefault");
    }


    byte[] getUnparsedAttributeData(String name){
        for(int i = 0; i < attributes.length; i++){

            if(attributes[i] instanceof Unparsed
                    && Utils.textEquals(name, attributes[i].attributeName)){

                return ((Unparsed) attributes[i]).getInfo();
            }
        }

        return null;
    }
}
