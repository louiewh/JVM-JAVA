package com.wh.jvm.instruction.math.div;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class DivFloat extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        float value1 = frame.mOpStack.popFloat();
        float value2 = frame.mOpStack.popFloat();

        float result = value2 / value1;

        frame.mOpStack.pushFloat(result);
    }
}
