package com.wh.jvm.instruction.math.neg;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class NegLong extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        long value = frame.mOpStack.popLong();

        frame.mOpStack.pushLong(-value);
    }
}
