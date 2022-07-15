package cn.jaylong.web.enums

import cn.jaylong.core.exception.IException

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
enum class HttpException(
    @JvmField var code: String,
    @JvmField var message: String
) : IException {
    HTTP_ERROR("109990001", "http请求异常"),

    ;

    override fun getCode(): String {
        return code
    }

    override fun getMessage(): String {
        return message
    }
}