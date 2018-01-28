package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.Jobject;
import com.wh.jvm.rtda.StackFrame;

public class LoadA0 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        Jobject value = frame.mLocalVarsTable.getRef(0);
        frame.mOpStack.pushRef(value);
    }
}
