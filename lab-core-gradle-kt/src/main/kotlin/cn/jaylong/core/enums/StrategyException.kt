package cn.jaylong.core.enums

import cn.jaylong.core.exception.IException

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
enum class StrategyException(
    @JvmField var code: String,
    @JvmField var message: String
) : IException {
    // 策略模式异常
    STRATEGY_NOT_FOUND("109991001", "未找到指定的扩展实例");

    override fun getCode(): String {
        return code
    }

    override fun getMessage(): String {
        return message
    }
}