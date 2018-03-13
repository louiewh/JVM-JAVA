package com.wh.jvm.rtda;


import java.util.Vector;

public class LocalVarsTable extends Vector<Slot> {

    public LocalVarsTable(int maxLVT) {
        this.setSize(maxLVT);
    }


    public void setInt(int index, int value){
        this.set(index, new Slot(value, null));
    }

    public int getInt(int index){

        return (int) this.get(index).mNumber;
    }

    public void setLong(int index, long value){

        this.set(index, new Slot(value, null));
    }

    public long getLong(int index){

        return this.get(index).mNumber;
    }

    public void setFloat(int index, float value){
        this.set(index, new Slot(Float.floatToIntBits(value), null));
    }

    public float getFloat(int index){
        return Float.intBitsToFloat((int) this.get(index).mNumber);
    }

    public void setDouble(int index, double value){
        long longValue = Double.doubleToLongBits(value);
        setLong(index, longValue);
    }

    public double getDouble(int index){
        long longValue = getLong(index);
        return Double.longBitsToDouble(longValue);
    }

    public void setRef(int index, Jobject value){
        this.set(index, new Slot(-1, value));
    }

    public Jobject getRef(int index){

        return this.get(index).mJobject;
    }
}
