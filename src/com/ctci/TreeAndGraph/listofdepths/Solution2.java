package com.ctci.TreeAndGraph.listofdepths;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution2 {
    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        /*Visit the root*/
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current); // Add previous level
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null)
                    current.add(parent.left);
                if (parent.right != null)
                    current.add(parent.right);
            }
        }
        return result;
    }
}
// Time O(N)
// no extra space needed as this iterative approach