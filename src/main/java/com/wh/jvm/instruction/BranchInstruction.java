package com.wh.jvm.instruction;

public class BranchInstruction extends Instruction {
    protected int offset;

    @Override
    public void fetchOperands(CodeReader reader) {

        offset = reader.readInt16();
    }
}
