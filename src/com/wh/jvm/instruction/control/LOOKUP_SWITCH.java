package com.wh.jvm.instruction.control;

import com.wh.jvm.instruction.CodeReader;
import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.rtda.StackFrame;

public class LOOKUP_SWITCH extends Instruction{

    int defaultOffset;
    int low;
    int high;
    int[] jumpOffArray;

    @Override
    public void fetchOperands(CodeReader reader) {
        reader.skipPadding();
        this.defaultOffset = reader.readInt32();
        this.low = reader.readInt32();
        this.high = reader.readInt32();
        int jumpNumber = this.high - this.low + 1;
        this.jumpOffArray = reader.readInt32s(jumpNumber);
    }

    @Override
    public void execute(StackFrame frame) {

        int index = frame.mOpStack.popInt();

        int offset;
        if (index >= this.low && index <= this.high) {
            offset = this.jumpOffArray[index - this.low];
        } else {
            offset = this.defaultOffset;
        }

        branch(frame, offset);
    }
}
