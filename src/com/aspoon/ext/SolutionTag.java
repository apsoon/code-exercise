package com.aspoon.ext;

import java.lang.annotation.*;

/**
 * 解法标签
 *
 * @author aspoon
 */
@Retention(value = RetentionPolicy.SOURCE)
@Documented
@Target(ElementType.METHOD)
public @interface SolutionTag {

    /**
     * 标签类型列表
     *
     * @return TagEnum
     */
    TagEnum tag();
}
