package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LoadInt0 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        int value = frame.mLocalVarsTable.getInt(0);
        frame.mOpStack.pushInt(value);
    }
}
