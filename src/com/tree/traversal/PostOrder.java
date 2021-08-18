package com.tree.traversal;

import com.tree.TreeNode;

public class PostOrder {
    void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.data);
        }
    }
}
