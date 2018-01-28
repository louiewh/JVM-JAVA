package com.wh.jvm.instruction.conversions;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Float2Double extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        float valueF = frame.mOpStack.popFloat();

        double result = (double) valueF;

        frame.mOpStack.pushDouble(result);
    }
}
