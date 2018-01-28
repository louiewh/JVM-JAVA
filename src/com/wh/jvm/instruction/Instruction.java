package com.wh.jvm.instruction;

import com.wh.jvm.instruction.compare.acmp.IFACMPEQ;
import com.wh.jvm.instruction.compare.acmp.IFACMPGE;
import com.wh.jvm.instruction.compare.cmp.*;
import com.wh.jvm.instruction.compare.fi.*;
import com.wh.jvm.instruction.compare.icmp.*;
import com.wh.jvm.instruction.constants.*;
import com.wh.jvm.instruction.control.*;
import com.wh.jvm.instruction.conversions.*;
import com.wh.jvm.instruction.extend.WIDE;
import com.wh.jvm.instruction.load.*;
import com.wh.jvm.instruction.math.IncInt;
import com.wh.jvm.instruction.math.add.AddDouble;
import com.wh.jvm.instruction.math.add.AddFloat;
import com.wh.jvm.instruction.math.add.AddInt;
import com.wh.jvm.instruction.math.add.AddLong;
import com.wh.jvm.instruction.math.and.AndInt;
import com.wh.jvm.instruction.math.and.AndLong;
import com.wh.jvm.instruction.math.div.DivDouble;
import com.wh.jvm.instruction.math.div.DivFloat;
import com.wh.jvm.instruction.math.div.DivInt;
import com.wh.jvm.instruction.math.div.DivLong;
import com.wh.jvm.instruction.math.mul.MulDouble;
import com.wh.jvm.instruction.math.mul.MulFloat;
import com.wh.jvm.instruction.math.mul.MulInt;
import com.wh.jvm.instruction.math.mul.MulLong;
import com.wh.jvm.instruction.math.neg.NegDouble;
import com.wh.jvm.instruction.math.neg.NegFloat;
import com.wh.jvm.instruction.math.neg.NegInt;
import com.wh.jvm.instruction.math.neg.NegLong;
import com.wh.jvm.instruction.math.or.OrInt;
import com.wh.jvm.instruction.math.or.OrLong;
import com.wh.jvm.instruction.math.rem.RemDouble;
import com.wh.jvm.instruction.math.rem.RemFloat;
import com.wh.jvm.instruction.math.rem.RemInt;
import com.wh.jvm.instruction.math.rem.RemLong;
import com.wh.jvm.instruction.math.shift.*;
import com.wh.jvm.instruction.math.sub.SubDouble;
import com.wh.jvm.instruction.math.sub.SubFloat;
import com.wh.jvm.instruction.math.sub.SubInt;
import com.wh.jvm.instruction.math.sub.SubLong;
import com.wh.jvm.instruction.math.xor.XOrInt;
import com.wh.jvm.instruction.math.xor.XOrLong;
import com.wh.jvm.instruction.push.BiPush;
import com.wh.jvm.instruction.push.Sipush;
import com.wh.jvm.instruction.stack.*;
import com.wh.jvm.instruction.store.*;
import com.wh.jvm.instruction.swap.Swap;
import com.wh.jvm.rtda.StackFrame;

public class Instruction {
    public String instructionName;

    public String getInstructionName(){
        return instructionName;
    }

    public void setInstructionName(String name){
        instructionName = name;
    }

    public void fetchOperands(CodeReader reader) {

    }

    public void execute(StackFrame frame) {

    }

    protected void branch(StackFrame frame,  int offset) {
        int pc = frame.jvmThread.getPC();
        pc += offset;
        frame.nextPC = pc;
    }

    public static Instruction newInstruction(int opcode){

        Instruction instruction = null;
        switch (opcode) {
            case 0x00:
                instruction = new Nop();
                instruction.setInstructionName("nop");
                return instruction;
            case 0x01:
            instruction = new AConstNull();
            instruction.setInstructionName("aconst_null");
            return instruction;
            case 0x02:
                instruction = new IConstM1();
                instruction.setInstructionName("iconst_m1");
                return instruction;
            case 0x03:
                instruction = new IConst0();
                instruction.setInstructionName("iconst_0");
                return instruction;
            case 0x04:
                instruction = new IConst1();
                instruction.setInstructionName("iconst_1");
                return instruction;
            case 0x05:
                instruction = new IConst2();
                instruction.setInstructionName("iconst_2");
                return instruction;
            case 0x06:
                instruction = new IConst3();
                instruction.setInstructionName("iconst_3");
                return instruction;
            case 0x07:
                instruction = new IConst4();
                instruction.setInstructionName("iconst_4");
                return instruction;
            case 0x08:
                instruction = new IConst5();
                instruction.setInstructionName("iconst_5");
                return instruction;
            case 0x09:
                instruction = new LConst0();
                instruction.setInstructionName("lconst_0");
                return instruction;
            case 0x0a:
                instruction = new LConst1();
                instruction.setInstructionName("lconst_1");
                return instruction;
            case 0x0b:
                instruction = new FConst0();
                instruction.setInstructionName("fconst_0");
                return instruction;
            case 0x0c:
                instruction = new FConst1();
                instruction.setInstructionName("fconst_1");
                return instruction;
            case 0x0d:
                instruction = new FConst2();
                instruction.setInstructionName("fconst_2");
                return instruction;
            case 0x0e:
                instruction = new DConst0();
                instruction.setInstructionName("dconst_0");
                return instruction;
            case 0x0f:
                instruction = new DConst1();
                instruction.setInstructionName("dconst_1");
                return instruction;
            case 0x10:
                instruction = new BiPush();
                instruction.setInstructionName("bipush");
                return instruction;
            case 0x11:
                instruction = new Sipush();
                instruction.setInstructionName("sipush");
                return instruction;
            // case 0x12:
            // 	return &LDC{}
            // case 0x13:
            // 	return &LDC_W{}
            // case 0x14:
            // 	return &LDC2_W{}
            case 0x15:
                instruction = new LoadInt();
                instruction.setInstructionName("iload");
                return instruction;
            case 0x16:
                instruction = new LoadLong();
                instruction.setInstructionName("lload");
                return instruction;
            case 0x17:
                instruction = new LoadFloat();
                instruction.setInstructionName("fload");
                return instruction;
            case 0x18:
                instruction = new LoadDouble();
                instruction.setInstructionName("dload");
                return instruction;
            case 0x19:
                instruction = new LoadA();
                instruction.setInstructionName("aload");
                return instruction;
            case 0x1a:
                instruction = new LoadInt0();
                instruction.setInstructionName("iload_0");
                return instruction;
            case 0x1b:
                instruction = new LoadInt1();
                instruction.setInstructionName("iload_1");
                return instruction;
            case 0x1c:
                instruction = new LoadInt2();
                instruction.setInstructionName("iload_2");
                return instruction;
            case 0x1d:
                instruction = new LoadInt3();
                instruction.setInstructionName("iload_3");
                return instruction;
            case 0x1e:
                instruction = new LoadLong0();
                instruction.setInstructionName("lload_0");
                return instruction;
            case 0x1f:
                instruction = new LoadLong1();
                instruction.setInstructionName("lload_1");
                return instruction;
            case 0x20:
                instruction = new LoadLong2();
                instruction.setInstructionName("lload_2");
                return instruction;
            case 0x21:
                instruction = new LoadLong3();
                instruction.setInstructionName("lload_3");
                return instruction;
            case 0x22:
                instruction = new LoadFloat0();
                instruction.setInstructionName("fload_0");
                return instruction;
            case 0x23:
                instruction = new LoadFloat1();
                instruction.setInstructionName("fload_1");
                return instruction;
            case 0x24:
                instruction = new LoadFloat2();
                instruction.setInstructionName("fload_2");
                return instruction;
            case 0x25:
                instruction = new LoadFloat3();
                instruction.setInstructionName("fload_3");
                return instruction;
            case 0x26:
                instruction = new LoadDouble0();
                instruction.setInstructionName("dload_0");
                return instruction;
            case 0x27:
                instruction = new LoadDouble1();
                instruction.setInstructionName("dload_1");
                return instruction;
            case 0x28:
                instruction = new LoadDouble2();
                instruction.setInstructionName("dload_2");
                return instruction;
            case 0x29:
                instruction = new LoadDouble3();
                instruction.setInstructionName("dload_3");
                return instruction;
            case 0x2a:
                instruction = new LoadA0();
                instruction.setInstructionName("aload_0");
                return instruction;
            case 0x2b:
                instruction = new LoadA1();
                instruction.setInstructionName("aload_1");
                return instruction;
            case 0x2c:
                instruction = new LoadA2();
                instruction.setInstructionName("aload_2");
                return instruction;
            case 0x2d:
                instruction = new LoadA3();
                instruction.setInstructionName("aload_3");
                return instruction;
            // case 0x2e:
            // 	return iaload
            // case 0x2f:
            // 	return laload
            // case 0x30:
            // 	return faload
            // case 0x31:
            // 	return daload
            // case 0x32:
            // 	return aaload
            // case 0x33:
            // 	return baload
            // case 0x34:
            // 	return caload
            // case 0x35:
            // 	return saload
            case 0x36:
                instruction = new StoreInt();
                instruction.setInstructionName("istore");
                return instruction;
            case 0x37:
                instruction = new StoreLong();
                instruction.setInstructionName("lstore");
                return instruction;
            case 0x38:
                instruction = new StoreFloat();
                instruction.setInstructionName("fstore");
                return instruction;
            case 0x39:
                instruction = new StoreDouble();
                instruction.setInstructionName("dstore");
                return instruction;
            case 0x3a:
                instruction = new StoreA();
                instruction.setInstructionName("astore");
                return instruction;
            case 0x3b:
                instruction = new StoreInt0();
                instruction.setInstructionName("istore_0");
                return instruction;
            case 0x3c:
                instruction = new StoreInt1();
                instruction.setInstructionName("istore_1");
                return instruction;
            case 0x3d:
                instruction = new StoreInt2();
                instruction.setInstructionName("istore_2");
                return instruction;
            case 0x3e:
                instruction = new StoreInt3();
                instruction.setInstructionName("istore_3");
                return instruction;
            case 0x3f:
                instruction = new StoreLong0();
                instruction.setInstructionName("lstore_0");
                return instruction;
            case 0x40:
                instruction = new StoreLong1();
                instruction.setInstructionName("lstore_1");
                return instruction;
            case 0x41:
                instruction = new StoreLong2();
                instruction.setInstructionName("lstore_2");
                return instruction;
            case 0x42:
                instruction = new StoreLong3();
                instruction.setInstructionName("lstore_3");
                return instruction;
            case 0x43:
                instruction = new StoreFloat0();
                instruction.setInstructionName("fstore_0");
                return instruction;
            case 0x44:
                instruction = new StoreFloat1();
                instruction.setInstructionName("fstore_1");
                return instruction;
            case 0x45:
                instruction = new StoreFloat2();
                instruction.setInstructionName("fstore_2");
                return instruction;
            case 0x46:
                instruction = new StoreFloat3();
                instruction.setInstructionName("fstore_3");
                return instruction;
            case 0x47:
                instruction = new StoreDouble0();
                instruction.setInstructionName("dstore_0");
                return instruction;
            case 0x48:
                instruction = new StoreDouble1();
                instruction.setInstructionName("dstore_1");
                return instruction;
            case 0x49:
                instruction = new StoreDouble2();
                instruction.setInstructionName("dstore_2");
                return instruction;
            case 0x4a:
                instruction = new StoreDouble3();
                instruction.setInstructionName("dstore_3");
                return instruction;
            case 0x4b:
                instruction = new StoreA0();
                instruction.setInstructionName("astore_0");
                return instruction;
            case 0x4c:
                instruction = new StoreA1();
                instruction.setInstructionName("astore_1");
                return instruction;
            case 0x4d:
                instruction = new StoreA2();
                instruction.setInstructionName("astore_2");
                return instruction;
            case 0x4e:
                instruction = new StoreA3();
                instruction.setInstructionName("astore_3");
                return instruction;
            // case 0x4f:
            // 	return iastore
            // case 0x50:
            // 	return lastore
            // case 0x51:
            // 	return fastore
            // case 0x52:
            // 	return dastore
            // case 0x53:
            // 	return aastore
            // case 0x54:
            // 	return bastore
            // case 0x55:
            // 	return castore
            // case 0x56:
            // 	return sastore
            case 0x57:
                instruction = new Pop();
                instruction.setInstructionName("pop");
                return instruction;
            case 0x58:
                instruction = new Pop2();
                instruction.setInstructionName("pop2");
                return instruction;
            case 0x59:
                instruction = new Dup();
                instruction.setInstructionName("dup");
                return instruction;
            case 0x5a:
                instruction = new DupX1();
                instruction.setInstructionName("dup_x1");
                return instruction;
            case 0x5b:
                instruction = new DupX2();
                instruction.setInstructionName("dup_x2");
                return instruction;
            case 0x5c:
                instruction = new Dup2();
                instruction.setInstructionName("dup2");
                return instruction;
            case 0x5d:
                instruction = new Dup2X1();
                instruction.setInstructionName("dup2_x1");
                return instruction;
            case 0x5e:
                instruction = new Dup2X2();
                instruction.setInstructionName("dup2_x2");
                return instruction;
            case 0x5f:
                instruction = new Swap();
                instruction.setInstructionName("swap");
                return instruction;
            case 0x60:
                instruction = new AddInt();
                instruction.setInstructionName("iadd");
                return instruction;
            case 0x61:
                instruction = new AddLong();
                instruction.setInstructionName("ladd");
                return instruction;
            case 0x62:
                instruction = new AddFloat();
                instruction.setInstructionName("fadd");
                return instruction;
            case 0x63:
                instruction = new AddDouble();
                instruction.setInstructionName("dadd");
                return instruction;
            case 0x64:
                instruction = new SubInt();
                instruction.setInstructionName("isub");
                return instruction;
            case 0x65:
                instruction = new SubLong();
                instruction.setInstructionName("lsub");
                return instruction;
            case 0x66:
                instruction = new SubFloat();
                instruction.setInstructionName("fsub");
                return instruction;
            case 0x67:
                instruction = new SubDouble();
                instruction.setInstructionName("dsub");
                return instruction;
            case 0x68:
                instruction = new MulInt();
                instruction.setInstructionName("imul");
                return instruction;
            case 0x69:
                instruction = new MulLong();
                instruction.setInstructionName("lmul");
                return instruction;
            case 0x6a:
                instruction = new MulFloat();
                instruction.setInstructionName("fmul");
                return instruction;
            case 0x6b:
                instruction = new MulDouble();
                instruction.setInstructionName("dmul");
                return instruction;
            case 0x6c:
                instruction = new DivInt();
                instruction.setInstructionName("idiv");
                return instruction;
            case 0x6d:
                instruction = new DivLong();
                instruction.setInstructionName("ldiv");
                return instruction;
            case 0x6e:
                instruction = new DivFloat();
                instruction.setInstructionName("fdiv");
                return instruction;
            case 0x6f:
                instruction = new DivDouble();
                instruction.setInstructionName("ddiv");
                return instruction;
            case 0x70:
                instruction = new RemInt();
                instruction.setInstructionName("irem");
                return instruction;
            case 0x71:
                instruction = new RemLong();
                instruction.setInstructionName("lrem");
                return instruction;
            case 0x72:
                instruction = new RemFloat();
                instruction.setInstructionName("frem");
                return instruction;
            case 0x73:
                instruction = new RemDouble();
                instruction.setInstructionName("drem");
                return instruction;
            case 0x74:
                instruction = new NegInt();
                instruction.setInstructionName("ineg");
                return instruction;
            case 0x75:
                instruction = new NegLong();
                instruction.setInstructionName("lneg");
                return instruction;
            case 0x76:
                instruction = new NegFloat();
                instruction.setInstructionName("fneg");
                return instruction;
            case 0x77:
                instruction = new NegDouble();
                instruction.setInstructionName("dneg");
                return instruction;
            case 0x78:
                instruction = new ShiftIntLeft();
                instruction.setInstructionName("ishl");
                return instruction;
            case 0x79:
                instruction = new ShiftLongLeft();
                instruction.setInstructionName("lshl");
                return instruction;
            case 0x7a:
                instruction = new ShiftIntRight();
                instruction.setInstructionName("ishr");
                return instruction;
            case 0x7b:
                instruction = new ShiftLongRight();
                instruction.setInstructionName("lshr");
                return instruction;
            case 0x7c:
                instruction = new UShiftIntRight();
                instruction.setInstructionName("iushr");
                return instruction;
            case 0x7d:
                instruction = new UShiftLongRight();
                instruction.setInstructionName("lushr");
                return instruction;
            case 0x7e:
                instruction = new AndInt();
                instruction.setInstructionName("iand");
                return instruction;
            case 0x7f:
                instruction = new AndLong();
                instruction.setInstructionName("land");
                return instruction;
            case 0x80:
                instruction = new OrInt();
                instruction.setInstructionName("ior");
                return instruction;
            case 0x81:
                instruction = new OrLong();
                instruction.setInstructionName("lor");
                return instruction;
            case 0x82:
                instruction = new XOrInt();
                instruction.setInstructionName("ixor");
                return instruction;
            case 0x83:
                instruction = new XOrLong();
                instruction.setInstructionName("lxor");
                return instruction;
            case 0x84:
                instruction = new IncInt();
                instruction.setInstructionName("iinc");
                return instruction;
            case 0x85:
                instruction = new Int2Long();
                instruction.setInstructionName("i2l");
                return instruction;
            case 0x86:
                instruction = new Int2Float();
                instruction.setInstructionName("i2f");
                return instruction;
            case 0x87:
                instruction = new Int2Double();
                instruction.setInstructionName("i2d");
                return instruction;
            case 0x88:
                instruction = new Long2Int();
                instruction.setInstructionName("l2i");
                return instruction;
            case 0x89:
                instruction = new Long2Float();
                instruction.setInstructionName("l2f");
                return instruction;
            case 0x8a:
                instruction = new Long2Double();
                instruction.setInstructionName("l2d");
                return instruction;
            case 0x8b:
                instruction = new Float2Int();
                instruction.setInstructionName("f2i");
                return instruction;
            case 0x8c:
                instruction = new Float2Long();
                instruction.setInstructionName("f2l");
                return instruction;
            case 0x8d:
                instruction = new Float2Double();
                instruction.setInstructionName("f2d");
                return instruction;
            case 0x8e:
                instruction = new Double2Int();
                instruction.setInstructionName("d2i");
                return instruction;
            case 0x8f:
                instruction = new Double2Long();
                instruction.setInstructionName("d2l");
                return instruction;
            case 0x90:
                instruction = new Double2Float();
                instruction.setInstructionName("d2f");
                return instruction;
            case 0x91:
                instruction = new Int2Byte();
                instruction.setInstructionName("i2b");
                return instruction;
            case 0x92:
                instruction = new Int2Char();
                instruction.setInstructionName("i2c");
                return instruction;
            case 0x93:
                instruction = new Int2Short();
                instruction.setInstructionName("i2s");
                return instruction;
            case 0x94:
                instruction = new CmpLong();
                instruction.setInstructionName("lcmp");
                return instruction;
            case 0x95:
                instruction = new CmpFloatL();
                instruction.setInstructionName("fcmpl");
                return instruction;
            case 0x96:
                instruction = new CmpFloatG();
                instruction.setInstructionName("fcmpg");
                return instruction;
            case 0x97:
                instruction = new CmpDoubleL();
                instruction.setInstructionName("dcmpl");
                return instruction;
            case 0x98:
                instruction = new CmpDoubleG();
                instruction.setInstructionName("dcmpg");
                return instruction;
            case 0x99:
                instruction = new IFEQ();
                instruction.setInstructionName("ifeq");
                return instruction;
            case 0x9a:
                instruction = new IFNE();
                instruction.setInstructionName("ifne");
                return instruction;
            case 0x9b:
                instruction = new IFLT();
                instruction.setInstructionName("iflt");
                return instruction;
            case 0x9c:
                instruction = new IFGT();
                instruction.setInstructionName("ifge");
                return instruction;
            case 0x9d:
                instruction = new IFGT();
                instruction.setInstructionName("ifgt");
                return instruction;
            case 0x9e:
                instruction = new IFLE();
                instruction.setInstructionName("ifle");
                return instruction;
            case 0x9f:
                instruction = new IFICMPEQ();
                instruction.setInstructionName("if_icmpeq");
                return instruction;
            case 0xa0:
                instruction = new IFICMPNE();
                instruction.setInstructionName("if_icmpne");
                return instruction;
            case 0xa1:
                instruction = new IFICMPLT();
                instruction.setInstructionName("if_icmplt");
                return instruction;
            case 0xa2:
                instruction = new IFICMPGE();
                instruction.setInstructionName("if_icmpge");
                return instruction;
            case 0xa3:
                instruction = new IFICMPGT();
                instruction.setInstructionName("if_icmpgt");
                return instruction;
            case 0xa4:
                instruction = new IFICMPLE();
                instruction.setInstructionName("if_icmple");
                return instruction;
            case 0xa5:
                instruction = new IFACMPEQ();
                instruction.setInstructionName("if_acmpeq");
                return instruction;
            case 0xa6:
                instruction = new IFACMPGE();
                instruction.setInstructionName("if_acmpne");
                return instruction;
            case 0xa7:
                instruction = new GOTO();
                instruction.setInstructionName("goto");
                return instruction;
            // case 0xa8:
            // 	return &JSR{}
            // case 0xa9:
            // 	return &RET{}
            case 0xaa:
                instruction = new TABLE_SWITCH();
                instruction.setInstructionName("tableswitch");
                return instruction;
            case 0xab:
                instruction = new LOOKUP_SWITCH();
                instruction.setInstructionName("lookupswitch");
                return instruction;
            // case 0xac:
            // 	return ireturn
            // case 0xad:
            // 	return lreturn
            // case 0xae:
            // 	return freturn
            // case 0xaf:
            // 	return dreturn
            // case 0xb0:
            // 	return areturn
            // case 0xb1:
            // 	return _return
            //	case 0xb2:
            //		return &GET_STATIC{}
            // case 0xb3:
            // 	return &PUT_STATIC{}
            // case 0xb4:
            // 	return &GET_FIELD{}
            // case 0xb5:
            // 	return &PUT_FIELD{}
            //	case 0xb6:
            //		return &INVOKE_VIRTUAL{}
            // case 0xb7:
            // 	return &INVOKE_SPECIAL{}
            // case 0xb8:
            // 	return &INVOKE_STATIC{}
            // case 0xb9:
            // 	return &INVOKE_INTERFACE{}
            // case 0xba:
            // 	return &INVOKE_DYNAMIC{}
            // case 0xbb:
            // 	return &NEW{}
            // case 0xbc:
            // 	return &NEW_ARRAY{}
            // case 0xbd:
            // 	return &ANEW_ARRAY{}
            // case 0xbe:
            // 	return arraylength
            // case 0xbf:
            // 	return athrow
            // case 0xc0:
            // 	return &CHECK_CAST{}
            // case 0xc1:
            // 	return &INSTANCE_OF{}
            // case 0xc2:
            // 	return monitorenter
            // case 0xc3:
            // 	return monitorexit
            case 0xc4:
                instruction = new WIDE();
                instruction.setInstructionName("wide");
                return instruction;
            // case 0xc5:
            // 	return &MULTI_ANEW_ARRAY{}
            case 0xc6:
                instruction = new IFNUL();
                instruction.setInstructionName("ifnull");
                return instruction;
            case 0xc7:
                instruction = new IFNOTNULL();
                instruction.setInstructionName("ifnonnull");
                return instruction;
            case 0xc8:
                instruction = new GOTOW();
                instruction.setInstructionName("goto_w");
                return instruction;
            // case 0xc9:
            // 	return &JSR_W{}
            // case 0xca: breakpoint
            // case 0xfe: impdep1
            // case 0xff: impdep2
            default:
                throw new RuntimeException("UnSupported OpCode!!!");
        }

    }
}
