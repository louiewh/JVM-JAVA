package com.wh.jvm.instruction.push;

import com.wh.jvm.instruction.CodeReader;
import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;


/*
 * http://blog.csdn.net/sum_rain/article/details/39892219
 */

public class Sipush extends Instruction {
    private int mValue;

    @Override
    public void fetchOperands(CodeReader reader) {
        mValue = reader.readInt16();
    }

    @Override
    public void execute(StackFrame frame) {
        frame.mOpStack.pushInt(mValue);
    }
}
