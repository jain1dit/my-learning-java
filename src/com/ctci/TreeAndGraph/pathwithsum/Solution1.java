package com.ctci.TreeAndGraph.pathwithsum;

import com.tree.TreeNode;

import java.util.HashMap;

public class Solution1 {
    int countPathWithSum(TreeNode root, int targetSum) {
        return countPathWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private int countPathWithSum(TreeNode root, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (root == null)
            return 0;
        /*Count path with Sum ending at the current node*/
        runningSum += root.data;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        /*If runningSum equals targetSum, the one additional path starts at root
         * Add in this path */
        if (runningSum == targetSum) {
            totalPaths++;
        }
        /*Increment pathCount, recurse, then decrement pathCount.*/
        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathWithSum(root.left, targetSum, runningSum, pathCount);
        totalPaths += countPathWithSum(root.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);
        return totalPaths;
    }

    private void incrementHashTable(HashMap<Integer, Integer> pathCount, int key, int delta) {
        if (delta == 0) {  //*** doubt on this line
            pathCount.remove(key);
        } else {
            pathCount.put(key, delta);
        }
    }
}
// Time O(N)
//Space O(log N) for balanced tree and O(N) for unbalanced