package com.lzy;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int node) {
        this.val = node;
    }

    public TreeNode(int node, TreeNode left, TreeNode right) {
        this.val = node;
        this.left = left;
        this.right = right;
    }
}
