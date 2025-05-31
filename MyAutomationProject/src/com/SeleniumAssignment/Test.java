package com.SeleniumAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3, 4, 5};

        List<Integer> l = new ArrayList<>();
        for (int num : arr) {
            l.add(num);
        }

        Set<Integer> printed = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!printed.contains(arr[i])) {
                int freq = Collections.frequency(l, arr[i]);
                System.out.println(arr[i] + " frequency is " + freq);
                printed.add(arr[i]);
            }
        }
    }
}
