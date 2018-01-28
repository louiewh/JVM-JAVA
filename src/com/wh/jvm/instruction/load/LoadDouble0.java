package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LoadDouble0 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        double value = frame.mLocalVarsTable.getLong(0);
        frame.mOpStack.pushDouble(value);
    }
}
