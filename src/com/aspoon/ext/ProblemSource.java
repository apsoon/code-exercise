package com.aspoon.ext;

import java.lang.annotation.*;

/**
 * 题目来源
 *
 * @author aspoon
 */
@Retention(value = RetentionPolicy.SOURCE)
@Documented
@Target(ElementType.TYPE)
public @interface ProblemSource {

    /**
     * 题目地址
     *
     * @return url
     */
    String url();
}
