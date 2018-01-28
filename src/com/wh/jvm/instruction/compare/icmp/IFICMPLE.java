package com.wh.jvm.instruction.compare.icmp;

import com.wh.jvm.instruction.BranchInstruction;
import com.wh.jvm.rtda.StackFrame;

public class IFICMPLE extends BranchInstruction{

    @Override
    public void execute(StackFrame frame) {
        int value1 = frame.mOpStack.popInt();
        int value2 = frame.mOpStack.popInt();

        // TODO ref compare == or equal
        if(value2 <= value1){
            branch(frame, offset);
        }
    }
}
