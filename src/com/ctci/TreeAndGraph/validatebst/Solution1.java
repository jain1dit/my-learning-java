package com.ctci.TreeAndGraph.validatebst;

import com.tree.TreeNode;

public class Solution1 {
    boolean checkBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBST(TreeNode root, int min, int max) {
        if (root == null) return true;

        if (root.data <= min || root.data >= max)
            return false;

        if (!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max))
            return false;

        return true;
    }
}

//Time O(n)
//Space O(log n)
