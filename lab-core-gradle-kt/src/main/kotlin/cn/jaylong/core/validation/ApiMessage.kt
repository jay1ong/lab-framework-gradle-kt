package cn.jaylong.core.validation

import java.time.LocalDateTime

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
data class ApiMessage(
    var code: String,
    var timestamp: LocalDateTime? = LocalDateTime.now(),
    var message: String? = null,
    var data: Any? = null,
    var description: String? = null
)
