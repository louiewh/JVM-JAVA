package com.wh.jvm.instruction.stack;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Pop2 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        frame.mOpStack.popSlot();
        frame.mOpStack.popSlot();
    }
}
