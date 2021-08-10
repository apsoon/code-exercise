package com.aspoon.exercise.code.leetcode;

/*
92. 反转链表 II
难度
中等


给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


示例 1：


输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]


提示：

链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n


进阶： 你可以使用一趟扫描完成反转吗？
 */

import com.aspoon.exercise.code.ext.*;

/**
 * @author aspoon
 */
@Difficulty(level = DifficultyEnum.MEDIUM)
@ProblemTag(tags = {TagEnum.LINKED_LIST})
@ProblemSource(url = "https://leetcode-cn.com/problems/reverse-linked-list-ii/")
public class A92ReverseBetween {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1), n2 = new ListNode(2),
                n3 = new ListNode(3), n4 = new ListNode(4), n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        reverseBetween(n1, 2, 4);
    }

    /**
     * 思路2：使用多个指针
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        if (left == right) {
            return head;
        }

        ListNode sentinel = new ListNode(), first = null, pre = sentinel, tmp;

        sentinel.next = head;
        int num = 1;
        while (head != null) {
            if (num < left) {
                pre = head;
                head = head.next;
                num++;
            } else if (num == left) {
                first = head;
                head = head.next;
                first.next = null;
                num++;
            } else if (num == right) {
                first.next = head.next;
                head.next = pre.next;
                pre.next = head;
                return sentinel.next;
            } else {
                tmp = head;
                head = head.next;
                tmp.next = pre.next;
                pre.next = tmp;
                num++;
            }
        }

        return sentinel.next;
    }

    /**
     * 解法1：中间截断后反转链表再拼接
     */
    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        if (left == right) {
            return head;
        }
        // 哨兵节点
        ListNode sentinel = new ListNode(), idx = head, subHead = null, leftPre = sentinel, rightAft = null;
        sentinel.next = head;
        int idxNum = 1;

        while (idx != null && idxNum <= right) {
            if (idxNum < left) {
                leftPre = idx;
                idx = idx.next;
            } else if (idxNum == left) {
                subHead = idx;
                idx = idx.next;
            } else if (idxNum == right) {
                rightAft = idx.next;
                idx.next = null;
            } else {
                idx = idx.next;
            }
            idxNum++;
        }

        if (subHead == null) {
            return head;
        }

        leftPre.next = reverse(subHead);
        subHead.next = rightAft;

        return sentinel.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode sentinel = new ListNode(), tmp;
        while (head != null) {
            if (sentinel.next == null) {
                sentinel.next = head;
                head = head.next;
                sentinel.next.next = null;
            } else {
                tmp = sentinel.next;
                sentinel.next = head;
                head = head.next;
                sentinel.next.next = tmp;
            }
        }

        return sentinel.next;
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
