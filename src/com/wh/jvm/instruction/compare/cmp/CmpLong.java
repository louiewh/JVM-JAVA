package com.wh.jvm.instruction.compare.cmp;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class CmpLong extends Instruction{
    @Override
    public void execute(StackFrame frame) {
        long value1 = frame.mOpStack.popLong();
        long value2 = frame.mOpStack.popLong();

        if(value2 > value1){
            frame.mOpStack.pushInt(1);
        } else if(value1 == value2){
            frame.mOpStack.pushInt(0);
        } else {
            frame.mOpStack.pushInt(-1);
        }
    }
}
