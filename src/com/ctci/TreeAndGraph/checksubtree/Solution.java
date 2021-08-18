package com.ctci.TreeAndGraph.checksubtree;

import com.tree.TreeNode;

public class Solution {
    boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        getOrderString(t1, stringBuilder1);
        getOrderString(t2, stringBuilder2);
        return stringBuilder1.indexOf(stringBuilder2.toString()) != -1;
    }

    private void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }
        sb.append(node.data);
        sb.append(node.left);
        sb.append(node.right);
    }
}

// Time (n + m)
// Space (n+ m)
