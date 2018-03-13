package com.wh.jvm.instruction.math.rem;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

import java.math.BigDecimal;

public class RemFloat extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        float value1 = frame.mOpStack.popFloat();
        float value2 = frame.mOpStack.popFloat();

        if(value1 == 0){
            // here should is a Exception, but java can do this.
        }

        float result = new BigDecimal(value2 % value1).floatValue();
        frame.mOpStack.pushFloat(result);
    }
}
