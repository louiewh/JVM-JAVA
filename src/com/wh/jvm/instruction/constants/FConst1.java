package com.wh.jvm.instruction.constants;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class FConst1 extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        frame.mOpStack.pushFloat(1.0f);
    }
}
