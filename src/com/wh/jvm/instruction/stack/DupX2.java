package com.wh.jvm.instruction.stack;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.Slot;
import com.wh.jvm.rtda.StackFrame;

public class DupX2 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        Slot slot1 = frame.mOpStack.popSlot();
        Slot slot2 = frame.mOpStack.popSlot();
        Slot slot3 = frame.mOpStack.popSlot();

        frame.mOpStack.pushSlot(slot1);
        frame.mOpStack.pushSlot(slot3);
        frame.mOpStack.pushSlot(slot2);
        frame.mOpStack.pushSlot(slot1);
    }
}
