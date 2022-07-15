package cn.jaylong.core.validate

import cn.hutool.extra.validation.ValidationUtil
import cn.jaylong.core.exception.BizException
import javax.validation.ConstraintViolation

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
object ValidationUtil {

    fun <T> validate(bean: T, vararg groups: Class<*>?): Set<ConstraintViolation<T>>? {
        val violations = ValidationUtil.getValidator().validate(bean, *groups)
        if (violations.size > 0) {
            val stringBuilder = StringBuilder()
            stringBuilder.append("参数验证失败=>")
            for (violation in violations) {
                stringBuilder.append(violation.propertyPath)
                stringBuilder.append(":")
                stringBuilder.append(violation.message)
                stringBuilder.append(";")
            }
            throw BizException("109993001", stringBuilder.toString())
        }
        return violations
    }

}