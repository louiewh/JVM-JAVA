package com.wh.jvm.instruction.stack;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.Slot;
import com.wh.jvm.rtda.StackFrame;

public class Dup extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        Slot slot = frame.mOpStack.popSlot();

        frame.mOpStack.pushSlot(slot);
        frame.mOpStack.pushSlot(slot);
    }
}
