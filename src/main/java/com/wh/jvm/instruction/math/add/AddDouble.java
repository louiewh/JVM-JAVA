package com.wh.jvm.instruction.math.add;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class AddDouble extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        double value1 = frame.mOpStack.popDouble();
        double value2 = frame.mOpStack.popDouble();

        double result = value1 + value2;
        frame.mOpStack.pushDouble(result);
    }
}
