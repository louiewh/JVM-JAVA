package com.wh.jvm.instruction.store;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class StoreDouble2 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        double value = frame.mOpStack.popDouble();
        frame.mLocalVarsTable.setDouble(2, value);
    }
}
