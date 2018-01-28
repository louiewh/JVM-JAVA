package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Index8Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LoadLong extends Index8Instruction {

    @Override
    public void execute(StackFrame frame) {
        long value = frame.mLocalVarsTable.getLong(mIndex);
        frame.mOpStack.pushLong(value);
    }
}
