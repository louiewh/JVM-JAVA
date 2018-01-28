package com.wh.jvm.instruction.math.neg;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class NegFloat extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        float value = frame.mOpStack.popFloat();

        frame.mOpStack.pushFloat(-value);
    }
}
