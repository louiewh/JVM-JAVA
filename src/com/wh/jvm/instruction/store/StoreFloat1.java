package com.wh.jvm.instruction.store;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class StoreFloat1 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        int value = frame.mOpStack.popInt();
        frame.mLocalVarsTable.setInt(1, value);
    }
}
