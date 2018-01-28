package com.wh.jvm.instruction.conversions;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Double2Float extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        double valueD = frame.mOpStack.popDouble();

        float result = (float) valueD;

        frame.mOpStack.pushFloat(result);
    }
}
