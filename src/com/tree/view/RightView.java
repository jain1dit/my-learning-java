package com.tree.view;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightView {
    ArrayList<Integer> rightView(TreeNode node) {
        //add code here.
        ArrayList<Integer> retArrayList = new ArrayList<>();

        if (node == null)
            return retArrayList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();

            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                TreeNode temp = queue.poll();

                // add the right most element at
                // the level
                if (i == n)
                    retArrayList.add(temp.data);

                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);

                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return retArrayList;
    }
}
