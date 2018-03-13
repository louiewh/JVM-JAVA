package com.wh.jvm.instruction.store;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class StoreLong2 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        long value = frame.mOpStack.popLong();
        frame.mLocalVarsTable.setLong(2, value);
    }
}
