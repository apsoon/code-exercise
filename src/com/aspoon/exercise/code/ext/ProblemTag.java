package com.aspoon.exercise.code.ext;

import java.lang.annotation.*;

/**
 * 题目标签
 *
 * @author aspoon
 */
@Retention(value = RetentionPolicy.SOURCE)
@Documented
@Target(ElementType.TYPE)
public @interface ProblemTag {

    /**
     * 标签类型列表
     *
     * @return TagEnum[]
     */
    TagEnum[] tags();
}
