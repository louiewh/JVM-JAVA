package com.wh.jvm.rtda;

import com.wh.jvm.classfile.MethodInfo;

public class StackFrame {

    public JvmThread jvmThread;
    public StackFrame mNextFrame;
    public LocalVarsTable mLocalVarsTable;
    public OpStack mOpStack;
    public int nextPC;
    public MethodInfo mMethodInfo;

    public StackFrame(int maxLVT, int maxOPS){
        mLocalVarsTable = new LocalVarsTable(maxLVT);
        mOpStack = new OpStack(maxOPS);
    }

    public StackFrame (JvmThread thread, MethodInfo methodInfo) {
        jvmThread = thread;
        mLocalVarsTable = new LocalVarsTable(methodInfo.getCodeAttributeInfo().maxLocals);
        mOpStack = new OpStack(methodInfo.getCodeAttributeInfo().maxStack);
        mMethodInfo = methodInfo;
    }
}
