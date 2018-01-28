package com.wh.jvm.instruction.math.and;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class AndLong extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        long value1 = frame.mOpStack.popLong();
        long value2 = frame.mOpStack.popLong();

        long result = value1 & value2;

        frame.mOpStack.pushLong(result);
    }
}
