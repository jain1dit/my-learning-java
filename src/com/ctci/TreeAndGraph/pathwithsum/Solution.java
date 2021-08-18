package com.ctci.TreeAndGraph.pathwithsum;

import com.tree.TreeNode;

public class Solution {
    int countPathWithSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int pathsFromRoot = countPathWithSumFromNode(root, targetSum, 0);
        int pathsOnLeft = countPathWithSum(root.left, targetSum);
        int pathsOnRight = countPathWithSum(root.right, targetSum);
        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    private int countPathWithSumFromNode(TreeNode root, int targetSum, int currentSum) {
        if (root == null)
            return 0;
        currentSum += root.data;
        int totalPaths = 0;
        if (currentSum == targetSum) { // Found a path from the node
            targetSum++;
        }
        totalPaths += countPathWithSumFromNode(root.left, targetSum, currentSum);
        totalPaths += countPathWithSumFromNode(root.right, targetSum, currentSum);
        return totalPaths;
    }
}
//Time O(N log N) in a balanced Tree
//Time O(N^2) in a unbalanced Tree
