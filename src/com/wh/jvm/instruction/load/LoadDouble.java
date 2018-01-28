package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Index8Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LoadDouble extends Index8Instruction {

    @Override
    public void execute(StackFrame frame) {
        double value = frame.mLocalVarsTable.getLong(mIndex);
        frame.mOpStack.pushDouble(value);
    }
}
