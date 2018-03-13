package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.Jobject;
import com.wh.jvm.rtda.StackFrame;

public class LoadA2 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        Jobject value = frame.mLocalVarsTable.getRef(2);
        frame.mOpStack.pushRef(value);
    }
}
