package com.tree.view;

import com.tree.TreeNode;
import com.tree.QueueObject;

import java.util.*;

public class TopView {
    void topView(TreeNode root) {
        Queue<QueueObject> q = new LinkedList<>();
        Map<Integer, TreeNode> topViewMap = new TreeMap<>();

        if (root == null) {
            return ;
        } else {
            q.add(new QueueObject(0, root));
        }

        System.out.println("The top view of the tree is : ");

        // count function returns 1 if the container 
        // contains an element whose key is equivalent 
        // to hd, or returns zero otherwise.
        while (!q.isEmpty()) {
            QueueObject tmpTreeNode = q.poll();
            if (!topViewMap.containsKey(tmpTreeNode.hd)) {
                topViewMap.put(tmpTreeNode.hd, tmpTreeNode.node);
            }

            if (tmpTreeNode.node.left != null) {
                q.add(new QueueObject(tmpTreeNode.hd - 1, tmpTreeNode.node.left));
            }
            if (tmpTreeNode.node.right != null) {
                q.add(new QueueObject(tmpTreeNode.hd + 1, tmpTreeNode.node.right));
            }

        }
        for (Map.Entry<Integer, TreeNode> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue().data);
        }
    }
}
