package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Index8Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LoadFloat extends Index8Instruction {

    @Override
    public void execute(StackFrame frame) {
        float value = frame.mLocalVarsTable.getFloat(mIndex);
        frame.mOpStack.pushFloat(value);
    }
}
