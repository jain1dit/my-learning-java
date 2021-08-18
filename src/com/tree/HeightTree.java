package com.tree;

public class HeightTree {
    int height(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else {
            int a = height(node.left);
            int b = height(node.right);
            int c = Math.max(a, b);
            return 1 + c;
        }
    }
}
