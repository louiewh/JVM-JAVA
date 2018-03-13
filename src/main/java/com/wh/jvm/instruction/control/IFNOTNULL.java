package com.wh.jvm.instruction.control;

import com.wh.jvm.instruction.BranchInstruction;
import com.wh.jvm.rtda.Jobject;
import com.wh.jvm.rtda.StackFrame;

public class IFNOTNULL extends BranchInstruction{

    @Override
    public void execute(StackFrame frame) {
        Jobject jobject = frame.mOpStack.popRef();
        if(jobject != null){
            branch(frame, this.offset);
        }
    }
}
