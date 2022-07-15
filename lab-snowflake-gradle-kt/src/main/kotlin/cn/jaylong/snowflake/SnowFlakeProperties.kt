package cn.jaylong.snowflake

import cn.hutool.core.lang.Snowflake
import cn.hutool.core.util.IdUtil
import org.springframework.boot.context.properties.ConfigurationProperties
import java.util.*

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
@ConfigurationProperties(prefix = SnowFlakeProperties.PREFIX)
class SnowFlakeProperties {

    companion object {
        const val PREFIX: String = "lab.snowflake"
    }

    private val WORKER_ID_BITS = 5L

    private val MAX_WORKER_ID = (-1L shl WORKER_ID_BITS.toInt()).inv()

    private val DATA_CENTER_ID_BITS = 5L

    private val MAX_DATA_CENTER_ID = (-1L shl DATA_CENTER_ID_BITS.toInt()).inv()

    var epochDate = Date(1288834974657L)

    var workerId = IdUtil.getWorkerId(IdUtil.getDataCenterId(MAX_DATA_CENTER_ID), MAX_WORKER_ID)

    var dataCenterId = IdUtil.getDataCenterId(MAX_DATA_CENTER_ID)

    var useSystemClock = false

    var timeOffset = Snowflake.DEFAULT_TIME_OFFSET
}