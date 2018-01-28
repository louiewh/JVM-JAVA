package com.wh.jvm.instruction.extend;

import com.wh.jvm.instruction.CodeReader;
import com.wh.jvm.instruction.Instruction;
import com.wh.jvm.instruction.load.*;
import com.wh.jvm.instruction.math.IncInt;
import com.wh.jvm.instruction.store.StoreDouble;
import com.wh.jvm.instruction.store.StoreFloat;
import com.wh.jvm.instruction.store.StoreInt;
import com.wh.jvm.instruction.store.StoreLong;
import com.wh.jvm.rtda.StackFrame;

public class WIDE extends Instruction {
    private Instruction mModifyInstruction;

    @Override
    public void fetchOperands(CodeReader reader) {
        int opcode = reader.readUint8();
        switch (opcode){
            case 0x15:
                LoadInt loadInt = new LoadInt();
                loadInt.mIndex = reader.readUint16();
                mModifyInstruction = loadInt;
                break;
            case 0x16:
                LoadLong loadLong = new LoadLong();
                loadLong.mIndex = reader.readUint16();
                mModifyInstruction = loadLong;
                break;
            case 0x17:
                LoadFloat loadFloat = new LoadFloat();
                loadFloat.mIndex = reader.readUint16();
                mModifyInstruction = loadFloat;
                break;
            case 0x18:
                LoadDouble loadDouble = new LoadDouble();
                loadDouble.mIndex = reader.readUint16();
                mModifyInstruction = loadDouble;
                break;
            case 0x19:
                LoadA loadA = new LoadA();
                loadA.mIndex = reader.readUint16();
                mModifyInstruction = loadA;
                break;
            case 0x36:
                StoreInt storeInt = new StoreInt();
                storeInt.mIndex = reader.readUint16();
                mModifyInstruction = storeInt;
                break;
            case 0x37:
                StoreLong storeLong = new StoreLong();
                storeLong.mIndex = reader.readUint16();
                mModifyInstruction = storeLong;
                break;
            case 0x38:
                StoreFloat storeFloat = new StoreFloat();
                storeFloat.mIndex = reader.readUint16();
                mModifyInstruction = storeFloat;
                break;
            case 0x3a:
                StoreDouble storeDouble = new StoreDouble();
                storeDouble.mIndex = reader.readUint16();
                mModifyInstruction = storeDouble;
                break;
            case 0x84:
                IncInt incInt = new IncInt();
                incInt.mIndex = reader.readUint16();
                incInt.mConst = reader.readUint16();
                mModifyInstruction = incInt;
                break;
            case 0xa9:
                // TODO
                break;
        }
    }

    @Override
    public void execute(StackFrame frame) {
        mModifyInstruction.execute(frame);
    }
}
