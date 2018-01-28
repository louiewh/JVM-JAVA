package com.wh.jvm.instruction.constants;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LConst0 extends Instruction {

    @Override
    public void execute(StackFrame frame) {

        frame.mOpStack.pushLong(0);
    }
}
