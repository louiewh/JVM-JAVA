package com.wh.jvm.instruction.store;

import com.wh.jvm.instruction.Index8Instruction;
import com.wh.jvm.rtda.StackFrame;

public class StoreFloat extends Index8Instruction {

    @Override
    public void execute(StackFrame frame) {
        float value = frame.mOpStack.popFloat();
        frame.mLocalVarsTable.setFloat(mIndex, value);
    }
}
