package com.sia.java.practise.multithreading_practise;

import java.util.concurrent.Callable;

public class CallablePrac<V> implements Callable<Integer> {
    private int i;

    CallablePrac(int num) {
        this.i = num;
    }

    @Override
    public Integer call() throws Exception {
        return this.i;
    }
}
