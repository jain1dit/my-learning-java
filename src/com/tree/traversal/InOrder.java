package com.tree.traversal;

import com.tree.TreeNode;

public class InOrder {
    void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }
}
// BST inOrder Traversal will give ascending order