package com.aspoon.leetcode;

/*
14. 最长公共前缀
难度 简单

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。



示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。


提示：

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
通过次数582,565提交次数1,438,905
 */

import com.aspoon.ext.*;

/**
 * @author aspoon
 */
@ProblemTag(tags = {TagEnum.STRING})
@ProblemSource(url = "https://leetcode-cn.com/problems/longest-common-prefix/")
@Difficulty(level = DifficultyEnum.EASY)
public class A14LongestCommonPrefix {

    /**
     * 解析：
     * 取第一字符串为标准，记住索引后一次性获取子串
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            String std = strs[0];
            for (int i = 0; i < std.length(); i++) {
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || std.charAt(i) != strs[j].charAt(i)) {
                        return std.substring(0, i);
                    }
                }
            }
            return std;
        }
    }
}
