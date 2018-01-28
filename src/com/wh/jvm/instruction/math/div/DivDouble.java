package com.wh.jvm.instruction.math.div;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class DivDouble extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        double value1 = frame.mOpStack.popDouble();
        double value2 = frame.mOpStack.popDouble();

        double result = value2 / value1;

        frame.mOpStack.pushDouble(result);
    }
}
