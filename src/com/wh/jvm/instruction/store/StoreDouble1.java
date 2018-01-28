package com.wh.jvm.instruction.store;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class StoreDouble1 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        double value = frame.mOpStack.popDouble();
        frame.mLocalVarsTable.setDouble(1, value);
    }
}
