package com.wh.jvm.instruction.conversions;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Int2Float extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        int value = frame.mOpStack.popInt();

        float result = (long) value;

        frame.mOpStack.pushFloat(result);
    }
}
