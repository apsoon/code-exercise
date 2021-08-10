package com.aspoon.leetcode;

import com.aspoon.ext.ProblemSource;
import com.aspoon.ext.ProblemTag;
import com.aspoon.ext.SolutionTag;
import com.aspoon.ext.TagEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aspoon
 */
@ProblemTag(tags = {TagEnum.ARRAY, TagEnum.HASH})
@ProblemSource(url = "https://leetcode-cn.com/problems/two-sum/")
public class A1TwoSum {

    /**
     * 解法1: 使用map将可能结果及其索引缓存下来
     */
    @SolutionTag(tag = TagEnum.HASH)
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> store = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            // 当前值大于目标值，跳过
            if (nums[i] > target) {
                continue;
            }
            // 判断差值是否已经缓存，如果有缓存直接返回
            Integer index = store.get(target - nums[i]);
            if (index != null) {
                result[0] = index;
                result[1] = i;
                return result;
            }
            // 差值不存在，缓存当前值
            store.put(nums[i], i);
        }
        return result;
    }

    /**
     * 解法2：暴力破解 - 二重循环
     */
    @SolutionTag(tag = TagEnum.BRUTE_FORCE)
    public int[] twoSum(int[] nums, int target) {
        return null;
    }
}
