package com.wh.jvm.instruction.constants;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LConst1 extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        frame.mOpStack.pushLong(1);
    }
}
