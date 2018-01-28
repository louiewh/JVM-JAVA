package com.wh.jvm.instruction.math.rem;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

import java.math.BigDecimal;

public class RemDouble extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        double value1 = frame.mOpStack.popDouble();
        double value2 = frame.mOpStack.popDouble();

        if(value1 == 0){
            // here should is a Exception, but java can do this.
        }

        double result = new BigDecimal(value2 % value1).doubleValue();
        frame.mOpStack.pushDouble(result);
    }
}
