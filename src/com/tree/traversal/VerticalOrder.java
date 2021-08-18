package com.tree.traversal;

import java.util.*;

import com.tree.QueueObject;
import com.tree.TreeNode;

public class VerticalOrder {
    static ArrayList<Integer> verticalOrder(TreeNode root) {
        if (root == null)
            return null;

        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        int hd = 0;

        Queue<QueueObject> que = new LinkedList<>();
        que.add(new QueueObject(0, root));
        while (!que.isEmpty()) {
            QueueObject temp = que.poll();
            hd = temp.hd;
            TreeNode node = temp.node;
            if (m.containsKey(hd)) {
                m.get(hd).add(node.data);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(node.data);
                m.put(hd, al);
            }
            if (node.left != null)
                que.add(new QueueObject(hd - 1, node.left));
            if (node.right != null)
                que.add(new QueueObject(hd + 1, node.right));
        }
        ArrayList<Integer> returnArray = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
            ArrayList<Integer> al = entry.getValue();
            returnArray.addAll(al);
        }
        return returnArray;
    }
}
