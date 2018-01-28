package com.wh.jvm.instruction.control;

import com.wh.jvm.instruction.BranchInstruction;
import com.wh.jvm.instruction.CodeReader;
import com.wh.jvm.rtda.StackFrame;

public class GOTOW extends BranchInstruction {

    @Override
    public void fetchOperands(CodeReader reader) {
        this.offset = reader.readInt32();
    }

    @Override
    public void execute(StackFrame frame) {
        branch(frame, this.offset);
    }
}
