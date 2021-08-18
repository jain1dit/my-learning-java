package com.ctci.TreeAndGraph.successor;

import com.tree.TreeNode;

public class Solution {
    TreeNode inOrderSucc(TreeNode n) {
        if (n == null)
            return null;
        if (n.right != null)
            return leftMostChild(n.right);
        else {
            TreeNode q = n;
            TreeNode x = q.parent;
            //go up we are on left instead go right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private TreeNode leftMostChild(TreeNode node) {
        if (node == null)
            return null;

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
