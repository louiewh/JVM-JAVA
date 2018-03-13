package com.wh.jvm.instruction.store;

import com.wh.jvm.instruction.Index8Instruction;
import com.wh.jvm.rtda.StackFrame;

public class StoreLong extends Index8Instruction {

    @Override
    public void execute(StackFrame frame) {
        long value = frame.mOpStack.popLong();
        frame.mLocalVarsTable.setLong(mIndex, value);
    }
}
