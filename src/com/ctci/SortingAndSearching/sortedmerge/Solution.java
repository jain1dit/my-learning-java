package com.ctci.SortingAndSearching.sortedmerge;

public class Solution {
    // A is bigger array
    void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1; // Index of last element in array A
        int indexB = lastB - 1; // Index of last element in array B
        int indexMerged = lastB + lastA - 1; // end of merge array

        // Merge a and b starting from the end of element in each
        while (indexB > 0) {
            // if end of A is greater than end of B
            if (indexA > 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA]; // copy element
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }
            indexMerged--; // move indices
        }
    }
}
