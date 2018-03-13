package com.wh.jvm.instruction.math.rem;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class RemLong extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        long value1 = frame.mOpStack.popLong();
        long value2 = frame.mOpStack.popLong();

        if(value1 == 0){
            // here should is a Exception, but java can do this.
        }

        long result = value2 % value1;
        frame.mOpStack.pushLong(result);
    }
}
