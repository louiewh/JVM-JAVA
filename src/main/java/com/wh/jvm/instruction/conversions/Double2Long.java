package com.wh.jvm.instruction.conversions;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Double2Long extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        double valueD = frame.mOpStack.popDouble();

        long result = (long) valueD;

        frame.mOpStack.pushLong(result);
    }
}
