package com.ctci.RecursionAndDP.powerset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static ArrayList<ArrayList<Integer>> getSubset(List<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubset;
        if (set.size() == index) {
            allSubset = new ArrayList<>();
            allSubset.add(new ArrayList<>());
        } else {
            allSubset = getSubset(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allSubset) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            System.out.print("{ ");
            moreSubsets.forEach(System.out::print);
            System.out.println(" }");
            allSubset.addAll(moreSubsets);
        }
        return allSubset;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = getSubset(Arrays.asList(1, 3, 6, 8, 7, 9, 2), 0);
        //result.forEach( number-> number.forEach(System.out::print));

    }
}
