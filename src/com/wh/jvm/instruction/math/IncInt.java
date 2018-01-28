package com.wh.jvm.instruction.math;

import com.wh.jvm.instruction.CodeReader;
import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class IncInt extends Instruction {
    public int mIndex;
    public int mConst;

    @Override
    public void fetchOperands(CodeReader reader) {
        mIndex = reader.readUint8();
        mConst = reader.readInt8();
    }

    @Override
    public void execute(StackFrame frame) {
        int value = frame.mLocalVarsTable.getInt(mIndex);
        value += mConst;

        frame.mLocalVarsTable.setInt(mIndex, value);
    }
}
