package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LoadLong2 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        long value = frame.mLocalVarsTable.getLong(2);
        frame.mOpStack.pushLong(value);
    }
}
