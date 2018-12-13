package com.wh.jvm.rtda.heap;

import com.wh.jvm.Utils;
import com.wh.jvm.classfile.ClassFile;
import com.wh.jvm.classfile.ClassReader;
import com.wh.jvm.classpath.ClassPath;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

public class ClassLoader {

    private ClassPath mClassPath;
    private HashMap<String, JClass> mMap;

    public ClassLoader(ClassPath classPath){

        mClassPath = classPath;
        mMap = new HashMap<String, JClass>();
    }

    public JClass loadClass(String name){

        if(mMap.containsKey(name)){
            return mMap.get(name);
        }

        return loadNonArrayClass(name);
    }

    public JClass loadNonArrayClass(String name){
        byte[] bytes = readClass(name);
        JClass jClass = defineClass(bytes);

        link(jClass);

        return jClass;
    }

    public byte[] readClass(String name){

        return  mClassPath.readClass(name);
    }

    public JClass defineClass(byte[] bytes){
        JClass jClass = parseClass(bytes);
        jClass.mClassLoader = this;

        resolveSuperClass(jClass);
        resolveInterfaces(jClass);

        mMap.put(jClass.mClassName, jClass);

        return jClass;
    }

    public JClass parseClass(byte[] bytes){
        ClassFile classFile = ClassReader.read(new ByteArrayInputStream(bytes));

        return JClass.newJClass(classFile);
    }

    private void resolveSuperClass(JClass jClass){

        if(!Utils.textEquals(jClass.mClassName, "java/lang/Object")){

            jClass.mSuperClass = jClass.mClassLoader.loadClass(jClass.mSuperClassName);
        }
    }

    private void resolveInterfaces(JClass jClass){
        if(jClass.mInterfaceNames.length > 0){
            jClass.mInterfaceArray = new JClass[jClass.mInterfaceNames.length];
            for (int i = 0; i < jClass.mInterfaceNames.length; i++) {
                jClass.mInterfaceArray[i] = jClass.mClassLoader.loadClass(jClass.mInterfaceNames[i]);
            }
        }
    }

    private void link(JClass jClass){
        verify(jClass);
        prepare(jClass);
    }

    private void verify(JClass jClass){

    }

    private void prepare(JClass jClass){
        calcInstanceFieldSlotIds(jClass);
        calcStaticFieldSlotIds(jClass);
        allocAndInitStaticVars(jClass);
    }

    private void calcInstanceFieldSlotIds(JClass jClass){
        int slotId = 0;
        if(jClass.mSuperClass != null){
            slotId = jClass.mSuperClass.mInstanceSlotCount;
        }

        for (Field field:jClass.mFieldArray) {
            if(!field.isIsStatic()){
                slotId++;

                if(field.isLongOrDouble()){
                    slotId++;
                }
            }
        }

        jClass.mInstanceSlotCount = slotId;
    }

    private void calcStaticFieldSlotIds(JClass jClass){

        int slotId = 0;
        for (Field field:jClass.mFieldArray) {
            if(!field.isIsStatic()){
                slotId++;

                if(field.isLongOrDouble()){
                    slotId++;
                }
            }
        }

        jClass.mStaticSlotCount = slotId;
    }

    private void allocAndInitStaticVars(JClass jClass){
        jClass.mStaticSlotTable = SlotTable.newSlotTable(jClass.mStaticSlotCount);

        for (Field field:jClass.mFieldArray) {
            if(field.isIsStatic() && field.isFinal()){
                initStaticFinalVar(jClass, field);
            }
        }

    }

    private void initStaticFinalVar(JClass jClass, Field field){

        SlotTable slot = jClass.mStaticSlotTable;
        RuntimeConstantPool runtimeConstantPool = jClass.mRtConstantPool;
        int index = field.getConstValueIndex().getValue();
        int slotId = field.mSlotId.getValue();

        if(index > 0){

            if (Utils.textEquals(field.mDescriptor, "Z")
                    || Utils.textEquals(field.mDescriptor, "B")
                    || Utils.textEquals(field.mDescriptor, "C")
                    || Utils.textEquals(field.mDescriptor, "S")
                    || Utils.textEquals(field.mDescriptor, "I")) {

                Object integer = runtimeConstantPool.getRuntimeConstant(index);
                slot.setInt(index, (Integer) integer);
            } else if (Utils.textEquals(field.mDescriptor, "J")) {

                Object longer = runtimeConstantPool.getRuntimeConstant(index);
                slot.setLong(index, (Long) longer);
            } else if (Utils.textEquals(field.mDescriptor, "F")) {

                Object floater = runtimeConstantPool.getRuntimeConstant(index);
                slot.setFloat(index, (Float) floater);
            } else if (Utils.textEquals(field.mDescriptor, "D")) {

                Object doubler = runtimeConstantPool.getRuntimeConstant(index);
                slot.setDouble(index, (Double) doubler);
            } else if (Utils.textEquals(field.mDescriptor, "Ljava/lang/String;")) {
                throw new RuntimeException("initStaticFinalVar TODO");
            }
        }
    }
}
