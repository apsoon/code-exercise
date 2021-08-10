package com.aspoon.exercise.code.ext;

import java.lang.annotation.*;

/**
 * @author aspoon
 */
@Retention(value = RetentionPolicy.SOURCE)
@Documented
@Target(ElementType.TYPE)
public @interface Difficulty {

    /**
     * 难度
     *
     * @return DifficultyEnum
     */
    DifficultyEnum level();
}
