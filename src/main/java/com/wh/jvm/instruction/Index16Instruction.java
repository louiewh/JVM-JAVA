package com.wh.jvm.instruction;

import com.wh.jvm.rtda.StackFrame;

public class Index16Instruction extends Instruction {

    private int mIndex;

    @Override
    public void fetchOperands(CodeReader reader) {
        mIndex = reader.readUint16();
    }

    @Override
    public void execute(StackFrame frame) {
        super.execute(frame);
    }
    
}
