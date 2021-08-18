package com.tree.traversal;

import com.tree.TreeNode;

public class PreOrder {
    void preOrderTraversal(TreeNode node){
        if(node!=null){
            System.out.println(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}
