package com.wh.jvm.instruction.store;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class StoreLong3 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        long value = frame.mOpStack.popLong();
        frame.mLocalVarsTable.setLong(3, value);
    }
}
