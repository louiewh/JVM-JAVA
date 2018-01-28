package com.wh.jvm.instruction.math.rem;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class RemInt extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        int value1 = frame.mOpStack.popInt();
        int value2 = frame.mOpStack.popInt();

        if(value1 == 0){
            // here should is a Exception, but java can do this.
        }

        int result = value2 % value1;
        frame.mOpStack.pushInt(result);
    }
}
