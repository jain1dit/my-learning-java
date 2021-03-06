package com.ctci.TreeAndGraph.commonAncestor;

import com.tree.TreeNode;

public class Solution3 {
    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // check one node is not in the tree
        if (!covers(root, p) || !covers(root, q))
            return null;
        return ancestorHelper(root, p, q);
    }

    private TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.left, q);
        // node on different side
        if (pIsOnLeft != qIsOnLeft) return root;
        TreeNode childSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    private boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }
}
