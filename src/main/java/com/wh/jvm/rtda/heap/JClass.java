package com.wh.jvm.rtda.heap;

import com.wh.jvm.classfile.ClassFile;
import com.wh.jvm.classfile.basictype.U2;
import com.wh.jvm.rtda.Jobject;

public class JClass {

    public U2 mAccessFlags;
    public String mClassName;
    public String mSuperClassName;
    public String[] mInterfaceNames;
    public RuntimeConstantPool mRtConstantPool;
    public Field[] mFieldArray;
    public Method[] mMethodArray;
    public ClassLoader mClassLoader;
    public JClass mSuperClass;
    public JClass[] mInterfaceArray;
    public int mInstanceSlotCount;
    public int mStaticSlotCount;
    public SlotTable mStaticSlotTable;


    static public JClass newJClass(ClassFile classFile){
        JClass jClass = new JClass();
        jClass.mAccessFlags = classFile.accessFlags;
        jClass.mClassName = classFile.getClassName();
        jClass.mSuperClassName = classFile.getSuperClassName();
        jClass.mInterfaceNames= classFile.getInterfaceNames();
        jClass.mRtConstantPool = RuntimeConstantPool.newConstantPool(jClass, classFile.mConstantPool);
        jClass.mFieldArray = Field.newFields(jClass, classFile.fields);
        jClass.mMethodArray = Method.newMethods(jClass, classFile.methods);

        return  jClass;
    }

    public RuntimeConstantPool getRuntimeConstantPool() {
        return mRtConstantPool;
    }

    public int getInstanceSlotCountSlot() {
        return mInstanceSlotCount;
    }

    public SlotTable getStaticSlot() {
        return mStaticSlotTable;
    }

    public boolean isPublic(){

        return mAccessFlags.getValue() == AccessFlag.ACC_PUBLIC.mFlag;
    }

    public boolean isFinal(){

        return mAccessFlags.getValue() == AccessFlag.ACC_FINAL.mFlag;
    }


    public boolean isAbstract(){

        return mAccessFlags.getValue() == AccessFlag.ACC_ABSTRACT.mFlag;
    }

    public boolean isSynthetic(){

        return mAccessFlags.getValue() == AccessFlag.ACC_SYNTHETIC.mFlag;
    }

    public boolean isAnnotation(){

        return mAccessFlags.getValue() == AccessFlag.ACC_ANNOTATION.mFlag;
    }

    public boolean isEnum(){

        return mAccessFlags.getValue() == AccessFlag.ACC_ENUM.mFlag;
    }

    public boolean isAccessibleTo(JClass other){
        return isPublic() || getPackageName().equals(other.getPackageName());
    }

    public String getPackageName(){

        int index = mClassName.lastIndexOf("/");

        return mClassName.substring(0, index);

    }

    public Method getMainMethod(){

        return getStaticMethod("main", "([Ljava/lang/String;)V");

    }


    public Method getStaticMethod(String name, String descriptor ){

        for(int i = 0; i < mMethodArray.length; i++){
            Method method = mMethodArray[i];
            if(method.mName.equals(name)
                    && method.mDescriptor.equals(descriptor)){
                return method;
            }
        }

        return null;
    }

    public boolean isAssignableFrom(JClass jClass){
        if(this.equals(jClass)) return true;

        if(!this.isImplements(jClass)){

            return jClass.isSubClassOf(this);
        } else {
            return jClass.isImplements(this);
        }
    }

    public boolean isSubClassOf(JClass jClass){
        for (JClass c = this.mSuperClass; c != null; c = c.mSuperClass){
            if(this.equals(c)) return true;
        }

        return false;
    }

    public boolean isImplements(JClass jClass){
        for (JClass c = this.mSuperClass; c != null; c = c.mSuperClass){
            for (JClass interfacz:mInterfaceArray) {
                if(interfacz.equals(jClass) || interfacz.isSubInterfaceOf(jClass)){
                    return true;
                }
            }
        }

        return false;
    }


    public boolean isSubInterfaceOf(JClass jClass){
        for (JClass interfacz:mInterfaceArray){
            if(interfacz.equals(jClass) || interfacz.isSubInterfaceOf(jClass)){

                return true;
            }
        }

        return false;

    }


    public Jobject newObject(){
        return Jobject.newObject(this);
    }

    public enum AccessFlag {
        ACC_PUBLIC(0x0001),       // class field method
        ACC_PRIVATE(0x0002),      //       field method
        ACC_PROTECTED(0x0004),    //       field method
        ACC_STATIC(0x0008),       //       field method
        ACC_FINAL(0x0010),        // class field method
        ACC_SUPER(0x0020),        // class
        ACC_SYNCHRONIZED(0x0020), //       method
        ACC_VOLATILE(0x0040),     //       field
        ACC_BRIDGE(0x0040),       //       method
        ACC_TRANSIENT(0x0080),    //       field
        ACC_VARARGS(0x0080),      //             method
        ACC_NATIVE(0x0100),       //             method
        ACC_INTERFACE(0x0200),    // class
        ACC_ABSTRACT(0x0400),     // class       method
        ACC_STRICT(0x0800),       //             method
        ACC_SYNTHETIC(0x1000),    // class field method
        ACC_ANNOTATION(0x2000),   // class
        ACC_ENUM(0x4000);        // class field


        public int mFlag;
        AccessFlag(int flag) {
            mFlag = flag;
        }
    }
}
