package com;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindLargestMultipleOf3 {

    // Driver code
    public static void main(String[] args) {
//        int arr[] = {4, 4, 1, 1, 1, 3};
        int arr[] = {5, 5, 5, 7};
        int n = arr.length;
        largest3Multiple(arr, n);
    }

    private static void largest3Multiple(int[] arr, int n) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            priorityQueue.add(arr[i]);
            sum += arr[i];
        }

        if (sum % 3 == 0) {
            System.out.println(sum);
        } else {
            int remainder = sum % 3;
            while (!priorityQueue.isEmpty()) {
                int elem = priorityQueue.poll();
//                System.out.println(elem);
                if (elem % 3 == remainder) {
                    sum -= elem;
                    break;
                } else {
                    remainder -= elem % 3;
                }
            }
        }
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.poll());
    }
}
