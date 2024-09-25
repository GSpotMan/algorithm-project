package com.lzy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;



public class test {

    @Test
    public void testInorderTraversal() {
        // 假设我们有一个方法返回一个值
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
