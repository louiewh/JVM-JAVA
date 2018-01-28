package com.wh.jvm.instruction;

import com.wh.jvm.rtda.StackFrame;

public class Index8Instruction extends Instruction {
    public int mIndex;

    @Override
    public void fetchOperands(CodeReader reader) {
        mIndex = reader.readUint8();
    }

    @Override
    public void execute(StackFrame frame) {
        super.execute(frame);
    }
}
