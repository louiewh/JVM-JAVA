package com.wh.jvm.instruction.conversions;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Float2Int extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        float valueF = frame.mOpStack.popFloat();

        int result = (int) valueF;

        frame.mOpStack.pushInt(result);
    }
}
