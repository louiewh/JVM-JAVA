package com.wh.jvm.instruction.conversions;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Int2Long extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        int value = frame.mOpStack.popInt();

        long result = (long) value;

        frame.mOpStack.pushLong(result);
    }
}
