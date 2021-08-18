package com.ctci.TreeAndGraph.commonAncestor;


import com.tree.TreeNode;

public class Solution2 {

    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //check if node covers each other in the tree
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, p))
            return p;
        else if (covers(q, p))
            return q;
        TreeNode sibling = getSiblings(p);
        TreeNode parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSiblings(parent);
            parent = parent.parent;
        }
        return parent;
    }

    private TreeNode getSiblings(TreeNode node) {
        if (node == null || node.parent == null)
            return null;

        TreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    private boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }
}
