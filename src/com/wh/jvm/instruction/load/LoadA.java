package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Index8Instruction;
import com.wh.jvm.rtda.Jobject;
import com.wh.jvm.rtda.StackFrame;

public class LoadA extends Index8Instruction {

    @Override
    public void execute(StackFrame frame) {
        Jobject value = frame.mLocalVarsTable.getRef(mIndex);
        frame.mOpStack.pushRef(value);
    }
}
