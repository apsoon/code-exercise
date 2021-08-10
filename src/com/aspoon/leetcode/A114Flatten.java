package com.aspoon.leetcode;

/*
114. 二叉树展开为链表
难度 中等

给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。

示例 1：

输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [0]
输出：[0]

提示：

树中结点数在范围 [0, 2000] 内
-100 <= Node.val <= 100

进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */


import com.aspoon.ext.*;

import java.util.Stack;

/**
 * @author aspoon
 */
@ProblemTag(tags = {TagEnum.STACK, TagEnum.TREE, TagEnum.DFS, TagEnum.LINKED_LIST, TagEnum.BINARY_TREE})
@ProblemSource(url = "https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/")
@Difficulty(level = DifficultyEnum.MEDIUM)
public class A114Flatten {

    /**
     * 解法1：前序遍历
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode ext = null, tmp;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            if (ext == null) {
                ext = tmp;
            } else {
                ext.right = tmp;
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            ext.left = null;
        }
    }

    // TODO: 2021/8/10 解法2

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
