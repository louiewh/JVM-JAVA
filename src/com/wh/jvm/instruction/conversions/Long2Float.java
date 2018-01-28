package com.wh.jvm.instruction.conversions;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Long2Float extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        long value = frame.mOpStack.popLong();

        float result = (float) value;

        frame.mOpStack.pushFloat(result);
    }
}
