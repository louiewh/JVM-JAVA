package com.wh.jvm.instruction.math.div;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class DivInt extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        int value1 = frame.mOpStack.popInt();
        int value2 = frame.mOpStack.popInt();

        int result = value2 / value1;

        frame.mOpStack.pushInt(result);
    }
}
