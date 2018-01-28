package com.wh.jvm;

public class Test {

    public int sum(){
        int i = 0;
        int sum = 0;
        for(i = 0; i < 100; i++){
            sum += i;
        }

        return sum;
    }
}
