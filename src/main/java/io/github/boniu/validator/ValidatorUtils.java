/**
 * Copyright (c) 2016-2019  All rights reserved.
 * <p>
 * https://www.7-me.net
 * <p>
 * 版权所有，侵权必究！
 */

package io.github.boniu.validator;

import io.github.boniu.exception.TheException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * hibernate-validator校验工具类
 * <p>
 * 参考文档：<a href="http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/">...</a>
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 *
 * @author Mark sunlightcs@gmail.com
 */
public class ValidatorUtils {

    private static final Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    /**
     * 校验对象
     *
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws TheException 校验不通过，则报 WgException 异常
     */
    public static void validateEntity(Object object, Class<?>... groups) throws TheException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for (ConstraintViolation<Object> constraint : constraintViolations) {
                msg.append(constraint.getMessage()).append("<br>");
            }
            throw new TheException(msg.toString());
        }
    }
    
    /************************************************************************
     * @author: wg
     * @description: 有 组的话用上面那个, 没组用这个
     * @params:
     * @return:
     * @createTime: 11:35  2023/7/25
     * @updateTime: 11:35  2023/7/25
     ************************************************************************/
    public static void validateEntity(Object object) throws TheException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for (ConstraintViolation<Object> constraint : constraintViolations) {
                msg.append(constraint.getMessage()).append("; ");
            }
            throw new TheException(msg.toString());
        }
    }

}
