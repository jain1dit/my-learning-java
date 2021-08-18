package com.tree.traversal;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalOrder {
    static void diagonalPrint(TreeNode root) {
        // create a map of vectors 
        // to store Diagonal elements
        HashMap<Integer, List<Integer>> diagonalPrint = new HashMap<>();
        diagonalPrintUtil(root, 0, diagonalPrint);

        System.out.println("Diagonal Traversal of Binary Tree");
        for (Map.Entry<Integer, List<Integer>> entry : diagonalPrint.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static void diagonalPrintUtil(TreeNode root, int d, HashMap<Integer, List<Integer>> diagonalPrint) {
        // Base case
        if (root == null)
            return;

        // get the list at the particular d value
        List<Integer> k = diagonalPrint.get(d);

        // k is null then create a
        // ArrayList and store the data
        if (k == null) {
            k = new ArrayList<>();
            k.add(root.data);
        }

        // k is not null then update the list
        else {
            k.add(root.data);
        }

        // Store all nodes of same line
        // together as a vector
        diagonalPrint.put(d, k);

        // Increase the vertical distance
        // if left child
        diagonalPrintUtil(root.left, d + 1, diagonalPrint);

        // Vertical distance remains
        // same for right child
        diagonalPrintUtil(root.right, d, diagonalPrint);
    }
}
