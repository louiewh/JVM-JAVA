package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LoadLong0 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        long value = frame.mLocalVarsTable.getLong(0);
        frame.mOpStack.pushLong(value);
    }
}
