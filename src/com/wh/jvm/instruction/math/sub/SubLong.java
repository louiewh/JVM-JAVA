package com.wh.jvm.instruction.math.sub;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class SubLong extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        long value1 = frame.mOpStack.popLong();
        long value2 = frame.mOpStack.popLong();

        long result = value2 - value1;

        frame.mOpStack.pushLong(result);
    }
}
