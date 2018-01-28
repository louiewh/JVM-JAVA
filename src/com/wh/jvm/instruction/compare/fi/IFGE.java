package com.wh.jvm.instruction.compare.fi;

import com.wh.jvm.instruction.BranchInstruction;
import com.wh.jvm.rtda.StackFrame;

public class IFGE extends BranchInstruction{

    @Override
    public void execute(StackFrame frame) {
        int value = frame.mOpStack.popInt();
        if(value >= 0){
            branch(frame, offset);
        }
    }
}
