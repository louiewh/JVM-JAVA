package com.wh.jvm.rtda;


import java.util.Stack;

public class OpStack extends Stack<Slot>{

    public OpStack(int maxOPS) {
        super.setSize(maxOPS);
    }

    public void pushInt(int value){
        this.push(new Slot(value, null));
    }

    public int popInt(){
        return (int) this.pop().mNumber;
    }

    public void pushFloat(float value){
        Slot slot = new Slot(Float.floatToIntBits(value), null);
        this.push(slot);
    }

    public float popFloat(){
        Slot slot = this.pop();

        return Float.intBitsToFloat((int) slot.mNumber);
    }

    public void pushLong(long value){
        Slot slot = new Slot(value, null);

        this.push(slot);
    }

    public long popLong(){
        Slot slot = this.pop();

        return slot.mNumber;
    }


    public void pushDouble(double value){
        long longValue = Double.doubleToLongBits(value);
        pushLong(longValue);

    }

    public Double popDouble(){
        long longValue = this.pop().mNumber;

        return Double.longBitsToDouble(longValue);
    }

    public void pushRef(Jobject jobject){
        Slot slot = new Slot(-1, jobject);

        this.push(slot);
    }

    public Jobject popRef(){
        return this.pop().mJobject;
    }

    public void pushSlot(Slot slot){

        this.push(slot);
    }

    public Slot popSlot(){
        return this.pop();
    }
}
