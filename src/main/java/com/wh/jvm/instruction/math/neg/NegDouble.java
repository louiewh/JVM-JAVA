package com.wh.jvm.instruction.math.neg;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class NegDouble extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        double value = frame.mOpStack.popDouble();

        frame.mOpStack.pushDouble(-value);
    }
}
