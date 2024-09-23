package com.lzy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    //  kmp next数组
    public void getNext(int[] next, String s) {
        int j = 0;
        next[0] = j;
        // 从长度为2开始匹配才有意义
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j )) {
                j = next[j-1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

    //kmp
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int j = -1;
        int[] next = new int[needle.length()];
        getNext(next, needle);
        for (int i = 0; i < haystack.length(); i++) {
            // 从长度为2子串开始计算 速度快
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }

        }
        return -1;
    }

    // 459 法1 双字符串叠加
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    // 459 法2 kmp
    public boolean repeatedSubstringPattern2(String s) {
        int len = s.length();
        int[] next = new int[len];
        getNext(next, s);
        if (next[len - 1] > 0 && len % (len - next[len - 1]) == 0) {
            return true;
        }
        return false;

    }

    // 144.二叉树前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        };
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            };
            if (node.left != null) {
                stack.push(node.left);
            }

    }
            return list;


    }

    // 94.二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }
            stack.push(root);
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                node = node.right;
                stack.push(node.right);
            }

        }
        return list;

    }










}