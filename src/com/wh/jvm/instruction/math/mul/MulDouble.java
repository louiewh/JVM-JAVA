package com.wh.jvm.instruction.math.mul;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class MulDouble extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        double value1 = frame.mOpStack.popDouble();
        double value2 = frame.mOpStack.popDouble();

        double result = value1 * value2;

        frame.mOpStack.pushDouble(result);
    }
}
