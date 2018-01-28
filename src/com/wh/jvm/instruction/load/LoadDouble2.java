package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LoadDouble2 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        double value = frame.mLocalVarsTable.getLong(2);
        frame.mOpStack.pushDouble(value);
    }
}
