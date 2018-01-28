package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.Jobject;
import com.wh.jvm.rtda.StackFrame;

public class LoadA3 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        Jobject value = frame.mLocalVarsTable.getRef(3);
        frame.mOpStack.pushRef(value);
    }
}
