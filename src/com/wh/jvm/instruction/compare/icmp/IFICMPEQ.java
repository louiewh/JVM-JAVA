package com.wh.jvm.instruction.compare.icmp;

import com.wh.jvm.instruction.BranchInstruction;
import com.wh.jvm.rtda.StackFrame;

public class IFICMPEQ extends BranchInstruction{

    @Override
    public void execute(StackFrame frame) {
        int value1 = frame.mOpStack.popInt();
        int value2 = frame.mOpStack.popInt();

        if(value1 == value2){
            branch(frame, offset);
        }

    }
}
