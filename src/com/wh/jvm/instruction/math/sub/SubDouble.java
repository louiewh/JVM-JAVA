package com.wh.jvm.instruction.math.sub;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class SubDouble extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        double value1 = frame.mOpStack.popDouble();
        double value2 = frame.mOpStack.popDouble();

        double result = value2 - value1;

        frame.mOpStack.pushDouble(result);
    }
}
