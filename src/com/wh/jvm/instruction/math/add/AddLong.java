package com.wh.jvm.instruction.math.add;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class AddLong extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        long value1 = frame.mOpStack.popLong();
        long value2 = frame.mOpStack.popLong();

        long result = value1 + value2;
        frame.mOpStack.pushLong(result);
    }
}
