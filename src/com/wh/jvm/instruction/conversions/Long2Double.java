package com.wh.jvm.instruction.conversions;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Long2Double extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        long value = frame.mOpStack.popLong();

        double result = (double) value;

        frame.mOpStack.pushDouble(result);
    }
}
