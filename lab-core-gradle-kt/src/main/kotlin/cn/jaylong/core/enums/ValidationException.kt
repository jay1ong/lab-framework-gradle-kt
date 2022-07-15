package cn.jaylong.core.enums

import cn.jaylong.core.exception.IException

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
enum class ValidationException(
    @JvmField var code: String,
    @JvmField var message: String,
) : IException {

    // 策略模式异常
    STRATEGY_NOT_FOUND("109993001", "参数验证失败");

    override fun getCode(): String {
        return code
    }

    override fun getMessage(): String {
        return message
    }

}