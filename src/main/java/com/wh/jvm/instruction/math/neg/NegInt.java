package com.wh.jvm.instruction.math.neg;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class NegInt extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        int value = frame.mOpStack.popInt();

        frame.mOpStack.pushInt(-value);
    }
}
