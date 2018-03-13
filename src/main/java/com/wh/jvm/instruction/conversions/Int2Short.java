package com.wh.jvm.instruction.conversions;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Int2Short extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        int value = frame.mOpStack.popInt();

        short result = (short) value;

        frame.mOpStack.pushInt(result);
    }
}
