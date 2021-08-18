package com.tree.traversal;

import com.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    void levelOrderTraversal(TreeNode node) {
        if (node == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            System.out.println(currNode.data);
            if (currNode.left != null)
                queue.add(currNode.left);
            if (currNode.right != null)
                queue.add(currNode.right);
        }
    }
}
