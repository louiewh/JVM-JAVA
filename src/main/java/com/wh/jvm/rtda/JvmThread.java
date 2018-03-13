package com.wh.jvm.rtda;

import com.wh.jvm.classfile.MethodInfo;
import com.wh.jvm.classfile.attributeinfo.Code;
import com.wh.jvm.instruction.CodeReader;
import com.wh.jvm.instruction.Instruction;

public class JvmThread extends Thread{
    private int mPC;
    private JvmStack mJvmStack;

    public JvmThread(){
        mJvmStack = new JvmStack(1024);
    }

    public int getPC(){
        return mPC;
    }

    public void setPC(int pc){
        mPC = pc;
    }

    public StackFrame popFrame() {
        return mJvmStack.pop();
    }


    public void pushFrame(StackFrame stackFrame){
        mJvmStack.push(stackFrame);
    }

    public StackFrame getCurrentFrame(){
        return mJvmStack.lastElement();
    }


    @Override
    public void run() {
        StackFrame stackFrame = popFrame();
        MethodInfo methodInfo = stackFrame.mMethodInfo;
        CodeReader codeReader = new CodeReader();
        Code codeAttributeInfo = methodInfo.getCodeAttributeInfo();

        codeReader.reset(codeAttributeInfo.code, 0);

        while (true){

            int pc = stackFrame.nextPC;
            this.setPC(pc);

            int opcode = codeReader.readUint8();
            Instruction instruction = Instruction.newInstruction(opcode);

            instruction.fetchOperands(codeReader);
            stackFrame.nextPC = codeReader.getPC();
            System.err.println(String.format("PC:%2d  Instruction:[%s]", pc, instruction.getInstructionName()));

            instruction.execute(stackFrame);
        }
    }
}
