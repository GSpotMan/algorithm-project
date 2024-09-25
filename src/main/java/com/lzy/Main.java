package com.lzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = null; // 列表中的 null 表示没有左子节点
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3); //
        list = solution.inorderTraversal(root);
        System.out.println(list);

    }
}