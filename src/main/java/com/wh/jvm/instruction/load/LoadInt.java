package com.wh.jvm.instruction.load;

import com.wh.jvm.instruction.Index8Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LoadInt extends Index8Instruction {

    @Override
    public void execute(StackFrame frame) {
        int value = frame.mLocalVarsTable.getInt(mIndex);
        frame.mOpStack.pushInt(value);
    }
}
