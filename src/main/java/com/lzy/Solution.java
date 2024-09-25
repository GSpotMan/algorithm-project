package com.lzy;

import java.sql.ClientInfoStatus;
import java.util.*;

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
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root =root.right;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        Collections.reverse(list);
        return list;
    }



    // 102.二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderFunc2(root,0);
        return listListresult;
    }

    public List<List<Integer>> levelOrderFunc1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = queue.peek();
                list.add(queue.poll().val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            result.add(list);

        }
//        List<Float> result2 =new ArrayList<>();
//        for (List<Integer> list : result) {
//            float temp = 0;
//            for (int i = 0; i < list.size(); i++) {
//                temp += list.get(i);
//            }
//            float avg = temp/list.size();
//            result2.add(avg);
//
//        }
        return result;
    }

    public List<List<Integer>> listListresult = new ArrayList<>();
    public void levelOrderFunc2(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (listListresult.size() <= deep) {
            listListresult.add(new ArrayList<>());
        }
        listListresult.get(deep).add(root.val);

        levelOrderFunc2(root.left, deep + 1);
        levelOrderFunc2(root.right, deep + 1);
    }

    // BFS

    /**
     *
     * @param root 输入值举例root = [3,9,20,null,null,15,7]，为TreeNode类型
     * @return  返回的是一个二维数组，包含每层的元素
     */
    public List<List<Integer>> BFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (root != null) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                list.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        // 一系列操作
        DFS(root.left);
        DFS(root.right);
    }






}