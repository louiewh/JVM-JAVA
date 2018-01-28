package com.wh.jvm.instruction.push;

import com.wh.jvm.instruction.CodeReader;
import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class BiPush extends Instruction {

    private  int mValue;
    @Override
    public void fetchOperands(CodeReader reader) {
        mValue = reader.readInt8();
    }

    @Override
    public void execute(StackFrame frame) {
        frame.mOpStack.pushInt(mValue);
    }
}
