package com.wh.jvm.instruction.conversions;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class Double2Int extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        double valueD = frame.mOpStack.popDouble();

        int result = (int) valueD;

        frame.mOpStack.pushInt(result);
    }
}
