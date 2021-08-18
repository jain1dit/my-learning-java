package com.ctci.TreeAndGraph.listofdepths;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null)    //best case
            return;
        LinkedList<TreeNode> list = null;
        if (list.size() == level) {
            list = new LinkedList<TreeNode>();
            /* Levels are always traversed in order. So if this is the first time we've visited level i, we
            * must have seen level 0 through i-1. we can therefore safely add the level at the end */
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }
}
// Time O(N)
// Space log(N)
