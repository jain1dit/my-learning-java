package com.tree;

public class TreeNode {
    public Integer data;
    public TreeNode left, right, parent;
    private int size = 0;

    public TreeNode(int i) {
        data = i;
        size = 1;
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                setLeftChild(new TreeNode(d));
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                setRightChild(new TreeNode(d));
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public TreeNode find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    public void setRightChild(TreeNode node) {
        this.right = node;
        if (right != null) {
            right.parent = this;
        }
    }

    public void setLeftChild(TreeNode node) {
        this.left = node;
        if (left != null) {
            left.parent = this;
        }
    }

    public int size() {
        return size;
    }

}
