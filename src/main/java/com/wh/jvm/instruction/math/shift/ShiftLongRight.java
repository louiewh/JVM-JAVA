package com.wh.jvm.instruction.math.shift;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class ShiftLongRight extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        int value1 = frame.mOpStack.popInt();
        long value2 = frame.mOpStack.popLong();

        long result = value2 >> value1 ;

        frame.mOpStack.pushLong(result);
    }
}
