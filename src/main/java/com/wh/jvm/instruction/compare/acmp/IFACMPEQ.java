package com.wh.jvm.instruction.compare.acmp;

import com.wh.jvm.instruction.BranchInstruction;
import com.wh.jvm.rtda.Jobject;
import com.wh.jvm.rtda.StackFrame;

public class IFACMPEQ extends BranchInstruction{

    @Override
    public void execute(StackFrame frame) {
        Jobject value1 = frame.mOpStack.popRef();
        Jobject value2 = frame.mOpStack.popRef();

        if(value1 == value2){
            branch(frame, offset);
        }

    }
}
