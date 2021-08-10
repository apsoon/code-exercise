package com.aspoon.leetcode;

/*
9. 回文数

给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

示例 1：

输入：x = 121
输出：true
示例 2：

输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3：

输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
示例 4：

输入：x = -101
输出：false

提示：

-231 <= x <= 231 - 1


进阶：你能不将整数转为字符串来解决这个问题吗？
 */

import com.aspoon.ext.*;

/**
 * @author aspoon
 */
@ProblemTag(tags = {TagEnum.MATH})
@ProblemSource(url = "https://leetcode-cn.com/problems/palindrome-number/")
@Difficulty(level = DifficultyEnum.EASY)
public class A9IsPalindrome {

    /**
     * 解法1：减去其逆转，如果等于0则为回文
     */
    @SolutionTag(tag = TagEnum.MATH)
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            int t = x, tr = 0;
            while (t != 0) {
                tr = tr * 10 + t % 10;
                t = t / 10;
            }
            return x == tr;
        }
    }

    /**
     * 解法2：转换成字符串，双指针
     */
    @SolutionTag(tag = TagEnum.TWO_POINTERS)
    public static boolean isPalindrome2(int x) {
        return false;
    }
}
