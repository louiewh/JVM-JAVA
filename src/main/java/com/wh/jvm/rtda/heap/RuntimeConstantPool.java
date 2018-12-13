package com.wh.jvm.rtda.heap;

import com.wh.jvm.classfile.constantpool.*;
import com.wh.jvm.rtda.heap.reference.ClassReference;
import com.wh.jvm.rtda.heap.reference.FieldReference;
import com.wh.jvm.rtda.heap.reference.InterfaceReference;
import com.wh.jvm.rtda.heap.reference.MethodReference;

public class RuntimeConstantPool {
    public JClass  mJClass;
    private Object[] mRtConstantPool;


    public static RuntimeConstantPool newConstantPool(JClass jClass, ConstantPool constantPool) {
        RuntimeConstantPool rtPool = new RuntimeConstantPool();

        rtPool.mJClass = jClass;
        rtPool.mRtConstantPool = new Object[constantPool.getConstantPoolCount().getValue()];
        ConstantPoolInfo[] cpInfoArray = constantPool.getCpInfo();
        for (int i = 0; i < cpInfoArray.length; i++) {
            ConstantPoolInfo constantPoolInfo = cpInfoArray[i];
            byte tag = constantPoolInfo.getTag();
            switch (tag) {
                case ConstantPoolInfo.CONSTANT_UTF8_INFO:
                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) constantPoolInfo;
                    rtPool.mRtConstantPool[i]= utf8Info.getValue();
                    break;
                case ConstantPoolInfo.CONSTANT_INTEGER_INFO:
                    ConstantIntegerInfo integerInfo = (ConstantIntegerInfo) constantPoolInfo;
                    rtPool.mRtConstantPool[i] = integerInfo.getBytesValue();
                    break;
                case ConstantPoolInfo.CONSTANT_FLOAT_INFO:
                    ConstantFloatInfo floatInfo = (ConstantFloatInfo) constantPoolInfo;
                    rtPool.mRtConstantPool[i] = floatInfo.getBytesValue();
                    break;
                case ConstantPoolInfo.CONSTANT_LONG_INFO:
                    ConstantLongInfo longInfo = (ConstantLongInfo) constantPoolInfo;
                    rtPool.mRtConstantPool[i] = longInfo.getBytesValue();
                    i++;
                    break;
                case ConstantPoolInfo.CONSTANT_DOUBLE_INFO:
                    ConstantDoubleInfo doubleInfo = (ConstantDoubleInfo) constantPoolInfo;
                    rtPool.mRtConstantPool[i] = (doubleInfo.getBytesValue());
                    i++;
                    break;
                case ConstantPoolInfo.CONSTANT_STRING_INFO:
                    ConstantStringInfo stringInfo = (ConstantStringInfo) constantPoolInfo;
                    rtPool.mRtConstantPool[i] = constantPool.getUtf8String(stringInfo.getIndex());
                    break;
                case ConstantPoolInfo.CONSTANT_CLASS_INFO:
                    ConstantClassInfo classInfo = (ConstantClassInfo) constantPoolInfo;
                    rtPool.mRtConstantPool[i] = ClassReference.newClassReference(rtPool, classInfo);
                    break;
                case ConstantPoolInfo.CONSTANT_FIELD_REF_INFO:
                    ConstantFieldRefInfo fieldRefInfo = (ConstantFieldRefInfo) constantPoolInfo;
                    rtPool.mRtConstantPool[i] = FieldReference.newFieldRef(rtPool, fieldRefInfo);
                    break;
                case ConstantPoolInfo.CONSTANT_METHOD_REF_INFO:
                    ConstantMethodRefInfo methodRefInfo = (ConstantMethodRefInfo) constantPoolInfo;
                    rtPool.mRtConstantPool[i] = MethodReference.newInterfaceReference(rtPool, methodRefInfo);
                    break;
                case ConstantPoolInfo.CONSTANT_INTERFACE_METHOD_REF_INFO:
                    ConstantInterfaceMethodRefInfo interfaceMethodRefInfo = (ConstantInterfaceMethodRefInfo) constantPoolInfo;
                    rtPool.mRtConstantPool[i] = InterfaceReference.newInterfaceReference(rtPool, interfaceMethodRefInfo);
                    break;
                case ConstantPoolInfo.CONSTANT_NAME_AND_TYPE_INFO:
                    break;
                case ConstantPoolInfo.CONSTANT_METHOD_HANDLE_INFO:
                    break;
                case ConstantPoolInfo.CONSTANT_METHOD_TYPE_INFO:
                    break;
                case ConstantPoolInfo.CONSTANT_INVOKE_DYNAMIC_INFO:
                    break;
                default:
                    throw new RuntimeException("newRuntimeConstantPool");
            }
        }

        return rtPool;
    }


    public Object getRuntimeConstant(int index){

        return mRtConstantPool[index];
    }
}
