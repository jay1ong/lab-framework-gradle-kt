package cn.jaylong.core.net

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable


/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
@Serializable
data class ApiMessage(
    var code: String = "200",
    var timestamp: Instant = Clock.System.now(),
    var message: String? = null,
    @Contextual
    var data: Any? = null,
    var description: String? = null
)
