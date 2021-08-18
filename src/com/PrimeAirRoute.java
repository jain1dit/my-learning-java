package com;

import java.util.Map;
import java.util.TreeMap;

public class PrimeAirRoute {

    public static void primeAirRoute(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
        Map<Integer, Integer> returnMap = new TreeMap<>();
        // adding return path to map
        for (int i = 0; i < returnRouteList.length; i++) {
            returnMap.put(returnRouteList[i][1], returnRouteList[i][0]);
        }
        // iterate over forward path and find appropriate return
        for (int i = 0; i < forwardRouteList.length; i++) {
            if (returnMap.containsKey(maxTravelDist - forwardRouteList[i][1])) {
                System.out.println(forwardRouteList[i][0] + " " + returnMap.get(maxTravelDist - forwardRouteList[i][1]));
            }
        }

//        // when no route if best find the closest to max
//        1) Initialize a variable diff as infinite (Diff is used to store the
//        difference between pair and x).  We need to find the minimum diff.
//        2) Initialize two index variables l and r in the given sorted array.
//        (a) Initialize first to the leftmost index in ar1:  l = 0
//        (b) Initialize second  the rightmost index in ar2:  r = n-1
//        3) Loop while  l = 0
//        (a) If  abs(ar1[l] + ar2[r] - sum) < diff  then
//        update diff and result
//        (b) If (ar1[l] + ar2[r] <  sum )  then l++
//                (c) Else r--
//        4) Print the result.

    }
}
