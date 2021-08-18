package com.ctci.TreeAndGraph.checkbalanced;

import com.tree.TreeNode;

public class Solution {

    boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else return isBalanced(root.left) && isBalanced(root.right);
    }

    int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        return Math.max(getHeight(root.left), getHeight(root.right) + 1);
    }

// time complexity = > O(N log N)
}
