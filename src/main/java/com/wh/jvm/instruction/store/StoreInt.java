package com.wh.jvm.instruction.store;

import com.wh.jvm.instruction.Index8Instruction;
import com.wh.jvm.rtda.StackFrame;

public class StoreInt extends Index8Instruction {

    @Override
    public void execute(StackFrame frame) {
        int value = frame.mOpStack.popInt();
        frame.mLocalVarsTable.setInt(mIndex, value);
    }
}
