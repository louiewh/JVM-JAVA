package com.wh.jvm.instruction.store;

import com.wh.jvm.instruction.Index8Instruction;
import com.wh.jvm.rtda.StackFrame;

public class StoreDouble extends Index8Instruction {

    @Override
    public void execute(StackFrame frame) {
        double value = frame.mOpStack.popDouble();
        frame.mLocalVarsTable.setDouble(mIndex, value);
    }
}
