package com.wh.jvm.instruction.swap;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.Slot;
import com.wh.jvm.rtda.StackFrame;

public class Swap extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        Slot slot1 = frame.mOpStack.popSlot();
        Slot slot2 = frame.mOpStack.popSlot();

        frame.mOpStack.push(slot1);
        frame.mOpStack.push(slot2);
    }
}
