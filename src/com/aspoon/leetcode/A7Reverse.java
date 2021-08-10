package com.aspoon.leetcode;

import com.aspoon.ext.*;

/*
7. 整数反转
难度 简单

给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。


示例 1：

输入：x = 123
输出：321
示例 2：

输入：x = -123
输出：-321
示例 3：

输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0


提示：

-2^31 <= x <= 2^31 - 1

 */

/**
 * @author aspoon
 */
@Difficulty(level = DifficultyEnum.EASY)
@ProblemTag(tags = {TagEnum.MATH})
@ProblemSource(url = "https://leetcode-cn.com/problems/reverse-integer/")
public class A7Reverse {

    /**
     * 解法：
     * 超出int最大或最小值可以使用long型保存，long型和强转后的int值不同时说明超出了
     */
    @SolutionTag(tag = TagEnum.MATH)
    public int reverse(int x) {
        if (x >= 0 && x < 10) {
            return x;
        }
        long t = x;
        long tr = 0L;
        while (t != 0) {
            tr = tr * 10 + t % 10;
            t = t / 10;
        }
        int tx = (int) tr;
        if (tx - tr != 0) {
            return 0;
        }
        return tx;
    }
}
