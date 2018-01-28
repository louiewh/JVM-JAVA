package com.wh.jvm.instruction.constants;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class FConst0 extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        frame.mOpStack.pushFloat(0.0f);
    }
}
