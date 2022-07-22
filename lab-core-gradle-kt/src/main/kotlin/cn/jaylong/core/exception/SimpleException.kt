package cn.jaylong.core.exception

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/20
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
data class SimpleException(
    private var code: String,
    private var message: String
) : IException {

    override fun getCode(): String {
        return code
    }

    override fun getMessage(): String {
        return message
    }
}