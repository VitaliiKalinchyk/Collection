package com.epam.autotasks.collections;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var set = new RangedOpsIntegerSet2();


//        var time = System.currentTimeMillis();
//
//        for (int i = 0; i < 10000000; i++) {
//            set.add(i);
//        }
//        System.out.println(System.currentTimeMillis() - time);
//
//        time = System.currentTimeMillis();
//        for (int i = 10000000; i > -1; i--) {
//            set.remove(i);
//        }
//        System.out.println(System.currentTimeMillis() - time);


        var time = System.currentTimeMillis();
        set.add(0, 100000000);
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        set.remove(0, 100000000);
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();

    }
}
