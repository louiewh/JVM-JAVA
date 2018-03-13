package com.wh.jvm.instruction.control;

import com.wh.jvm.instruction.BranchInstruction;
import com.wh.jvm.rtda.StackFrame;

public class GOTO extends BranchInstruction {

    @Override
    public void execute(StackFrame frame) {
        branch(frame, this.offset);
    }
}
