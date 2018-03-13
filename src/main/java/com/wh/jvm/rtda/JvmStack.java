package com.wh.jvm.rtda;

import java.util.Stack;

public class JvmStack extends Stack<StackFrame> {

    public JvmStack(int maxSize) {
        this.setSize(maxSize);
    }
}
