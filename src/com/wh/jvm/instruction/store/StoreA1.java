package com.wh.jvm.instruction.store;

import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.Jobject;
import com.wh.jvm.rtda.StackFrame;

public class StoreA1 extends Instruction {

    @Override
    public void execute(StackFrame frame) {
        Jobject jobject= frame.mOpStack.popRef();
        frame.mLocalVarsTable.setRef(1, jobject);
    }
}
