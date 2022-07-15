package cn.jaylong.core.exception

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
data class BizException constructor(
    var code: String,
    override var message: String,
) : RuntimeException() {
    constructor(e: IException) : this(e.getCode(), e.getMessage())
}