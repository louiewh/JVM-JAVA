package com.wh.jvm.instruction.compare.cmp;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class CmpFloatL extends Instruction{
    @Override
    public void execute(StackFrame frame) {
        float value1 = frame.mOpStack.popFloat();
        float value2 = frame.mOpStack.popFloat();

        if(value1 < value2){
            frame.mOpStack.pushInt(1);
        } else if(value1 == value2){
            frame.mOpStack.pushInt(0);
        } else {
            frame.mOpStack.pushInt(-1);
        }
    }
}
