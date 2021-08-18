package com.collections;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;

public class Gfg {

    private static int compare(Pair<Integer, Integer> c1, Pair<Integer, Integer> c2) {
        if(c1.getKey() > c2.getKey())
            return -1;
        return  c1.getKey().equals(c2.getKey()) ? 0 : 1;
    }

    public int minSwaps(int[] arr, int N) {
        ArrayList<Pair<Integer, Integer>> arrpos = new ArrayList <Pair <Integer,Integer>>();
        for (int i = 0; i < N; i++)
            arrpos.add(new Pair <Integer, Integer> (arr[i], i));

        Collections.sort(arrpos, Gfg::compare);
        return 0;
    }
}
