package com.ctci.TreeAndGraph.checksubtree;

import com.tree.TreeNode;

public class Solution1 {
    boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true;
        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return false; // big tree empty and subtree still not found
        else if (t1.data == t2.data && matchTree(t1, t2))
            return true;
        return subTree(t1.left, t2) || subTree(t2.right, t2);
    }

    private boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;  //nothing left in the subtree
        else if (t1 == null || t2 == null)
            return false; // exactly one tree is null, therefore tree doesn't match
        else if (t1.data != t2.data)
            return false; // data doesn't match
        else
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
    }
}

// Time worst case O(nm)
// Space O(log(n) + log(m)