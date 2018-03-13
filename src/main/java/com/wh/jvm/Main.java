package com.wh.jvm;

import com.google.gson.Gson;
import com.wh.jvm.classfile.ClassFile;
import com.wh.jvm.classfile.MethodInfo;
import com.wh.jvm.classfile.constantpool.ConstantPoolInfo;
import com.wh.jvm.classfile.constantpool.ConstantUtf8Info;
import com.wh.jvm.rtda.JvmThread;
import com.wh.jvm.rtda.LocalVarsTable;
import com.wh.jvm.rtda.OpStack;
import com.wh.jvm.rtda.StackFrame;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    static final String[] mJvmArgs = {
            "java",
            "-version",
            "-help",
            "-classpath", "./target/classes",
    };

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello JVM !!!");
        for (int i = 0; i < args.length; i++){
            System.out.println("args:"+args[i]);
        }

        Jvm jvm = new Jvm();
        if(args.length > 0){
            jvm.startJvm(args);
        } else {
            jvm.startJvm(mJvmArgs);
        }

        testClassLoader(jvm);
        testClassFile(jvm);

        testLVS(jvm);
        testOpStack(jvm);

        testInterpret(jvm);
    }

    private static void testClassLoader(Jvm jvm){
        byte[] bytesObject = jvm.readClass("java.lang.Object");
        byte[] bytesJvm    = jvm.readClass("com.wh.jvm.Jvm");

        System.err.println(Utils.ByteArrayToHexString(bytesObject));
        System.err.println(Utils.ByteArrayToHexString(bytesJvm));
        System.err.flush();
    }

    private static void testClassFile(Jvm jvm) {
        try {
            InputStream inputStreamObject = new ByteArrayInputStream(jvm.readClass("java.lang.Object"));
            InputStream inputStreamJvm = new ByteArrayInputStream(jvm.readClass("com.wh.jvm.Jvm"));

            jvm.mClassReader.analyze(inputStreamObject);
            jvm.mClassReader.analyze(inputStreamJvm);
            inputStreamObject.reset();
            inputStreamJvm.reset();

            Gson gson = Utils.getGson();
            String gsonObject = gson.toJson(jvm.mClassReader.read(inputStreamObject));
            System.err.println(gsonObject);
            Utils.writeData("Object.json", gsonObject);

            String gsonJvm = gson.toJson(jvm.mClassReader.read(inputStreamJvm));
            System.err.println(gsonJvm);
            Utils.writeData("Jvm.json", gsonJvm);
            System.err.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testLVS(Jvm jvm){

        StackFrame stackFrame = new StackFrame(100, 100);
        LocalVarsTable localVarsTable = stackFrame.mLocalVarsTable;

        localVarsTable.setInt(0, 100);
        localVarsTable.setInt(1, Integer.MAX_VALUE);
        localVarsTable.setInt(2, Integer.MIN_VALUE);

        localVarsTable.setLong(3, (long)Integer.MAX_VALUE*2);
        localVarsTable.setFloat(4, 999.99f);
        localVarsTable.setDouble(5, 1001.888888d);
        localVarsTable.setRef(6, null);

        System.err.println("LocalVarsTable:");
        System.err.println(localVarsTable.getInt(0));
        System.err.println(localVarsTable.getInt(1));
        System.err.println(localVarsTable.getInt(2));
        System.err.println(localVarsTable.getLong(3));
        System.err.println(localVarsTable.getFloat(4));
        System.err.println(localVarsTable.getDouble(5));
        System.err.println(localVarsTable.getRef(6));
        System.err.flush();
    }

    private static void testOpStack(Jvm jvm){
        StackFrame stackFrame = new StackFrame(100, 100);
        OpStack opStack = stackFrame.mOpStack;

        opStack.pushInt(666);
        opStack.pushLong((long) 123456789);
        opStack.pushFloat(888.88f);
        opStack.pushDouble(999.99999999d);
        opStack.pushRef(null);

        System.err.println("OpStack:");
        System.err.println(opStack.popRef());
        System.err.println(opStack.popDouble());
        System.err.println(opStack.popFloat());
        System.err.println(opStack.popLong());
        System.err.println(opStack.popInt());
        System.err.flush();
    }

    private static void testInterpret(Jvm jvm){
        InputStream inputStreamJvm = new ByteArrayInputStream(jvm.readClass("com.wh.jvm.Jvm"));

        ClassFile classFile = jvm.mClassReader.read(inputStreamJvm);

        int len = classFile.methods.length;
        ConstantPoolInfo[] constantPool = classFile.cpInfo;
        MethodInfo[] methodInfoArray = classFile.methods;
        MethodInfo methodInfoFind = null;
        for(int i = 0; i < len; i++){
            MethodInfo methodInfo = methodInfoArray[i];
            ConstantUtf8Info utf8Info = (ConstantUtf8Info) constantPool[methodInfo.nameIndex -1];

            System.err.println("testInterpret MethodInfo : "+utf8Info.getValue());
            if(utf8Info.getValue().equals("sum")){
                methodInfoFind = methodInfo;
            }
        }

        JvmThread jvmThread = new JvmThread();
        StackFrame stackFrame = new StackFrame(jvmThread, methodInfoFind);

        jvmThread.pushFrame(stackFrame);
        jvmThread.run();
    }
}
