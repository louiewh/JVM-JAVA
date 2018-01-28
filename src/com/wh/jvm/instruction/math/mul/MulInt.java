package com.wh.jvm.instruction.math.mul;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class MulInt extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        int value1 = frame.mOpStack.popInt();
        int value2 = frame.mOpStack.popInt();

        int result = value1 * value2;

        frame.mOpStack.pushInt(result);
    }
}
