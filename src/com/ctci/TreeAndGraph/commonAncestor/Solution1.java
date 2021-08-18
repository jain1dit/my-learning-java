package com.ctci.TreeAndGraph.commonAncestor;

import javax.swing.tree.TreeNode;

public class Solution1 {

    TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q);
        TreeNode first = delta > 0 ? q : p; // get shallower node
        TreeNode second = delta > 0 ? p : q; // get deeper node
        second = goUpBy(second, Math.abs(delta));

        // find where parent intersect
        while (first != second && first != null && second != null) {
            first = first.getParent();
            second = second.getParent();
        }
        return first == null || second == null ? null : first;
    }

    private TreeNode goUpBy(TreeNode node, int abs) {
        while (abs > 0 && node != null) {
            node = node.getParent();
            abs--;
        }
        return node;
    }

    private int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.getParent();
            depth++;
        }
        return depth;
    }
}
