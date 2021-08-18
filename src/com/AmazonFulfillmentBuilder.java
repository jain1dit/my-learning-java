package com;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class AmazonFulfillmentBuilder {

    static int minTime(List<Integer> list) {
        if (list.isEmpty())
            return 0;
        int minTime = 0;
        PriorityQueue<Integer> prioQ = new PriorityQueue<>(list);
        while (prioQ.size() > 1) {
            int a = prioQ.poll();
            if (prioQ.peek() != null) {
                int b = prioQ.poll();
                int sum = a + b;
                minTime += sum;
                prioQ.add(sum);
            }
        }
        return minTime;
    }

    public static void main(String[] arg) {
        System.out.println(minTime(Arrays.asList(8, 4, 6, 12)));
    }
}
