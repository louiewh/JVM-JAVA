package com.wh.jvm.instruction.math.add;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class AddFloat extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        float value1 = frame.mOpStack.popFloat();
        float value2 = frame.mOpStack.popFloat();

        float result = value1 + value2;
        frame.mOpStack.pushFloat(result);
    }
}
