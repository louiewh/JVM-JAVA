package com.wh.jvm.rtda.heap;

import com.wh.jvm.rtda.Jobject;

public class SlotTable {
    public  Slot[] mSlotArray;

    public SlotTable(int slotCount ){
        mSlotArray = new Slot[slotCount];
    }

    static class Slot{
        long mNumber;
        Jobject  mJobject;

        public Slot(long value, Jobject o) {

            mNumber = value;
            mJobject = o;
        }
    }



    public static SlotTable newSlotTable(int slotCount){

        if(slotCount > 0) {
            return new SlotTable(slotCount);
        }

        return null;
    }


    public void setInt(int index, int val){

        mSlotArray[index].mNumber = val;
    }

    public int getInt(int index){

        return (int) mSlotArray[index].mNumber;
    }

    public void setFloat(int index, float val){

        mSlotArray[index].mNumber = Float.floatToIntBits(val);
    }

    public float getFloat(int index){

        return Float.intBitsToFloat((int) mSlotArray[index].mNumber);
    }

    public void setLong(int index, long val){
        mSlotArray[index].mNumber = val;
    }

    public long getLong(int index, long val){
        return mSlotArray[index].mNumber;
    }


    public void setDouble(int index, double val){

        mSlotArray[index].mNumber = Double.doubleToLongBits(val);
    }

    public double getDouble(int index){
        return Double.longBitsToDouble(mSlotArray[index].mNumber);
    }


    public void setRef(int index, Jobject ref){
        mSlotArray[index].mJobject = ref;
    }


    public Jobject getRef(int index){
        return mSlotArray[index].mJobject;
    }

}
