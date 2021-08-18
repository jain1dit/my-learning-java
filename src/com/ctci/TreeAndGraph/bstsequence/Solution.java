package com.ctci.TreeAndGraph.bstsequence;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {

    ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        // recurse to left and right subtrees
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        // weave together from left and right subtree
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveList(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    private void weaveList(LinkedList<Integer> left, LinkedList<Integer> right, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {

        // one of the list is empty , add remainder to prefix and store result
        if (left.isEmpty() || right.isEmpty()) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(left);
            result.addAll(right);
            results.addAll(Collections.singleton(result));
            return;
        }

        // Recurse with the head of left add to prefix. Removing the head will damage left, so we'll need to
        // to put it back where we found if afterwards.
        int headFirst = left.removeFirst();
        prefix.add(headFirst);
        weaveList(left, right, results, prefix);
        prefix.removeLast();
        left.addFirst(headFirst);

        //doing same thing to the right
        int headSecond = right.removeFirst();
        prefix.add(headSecond);
        weaveList(left, right, results, prefix);
        prefix.removeLast();
        right.addFirst(headSecond);
    }
}
