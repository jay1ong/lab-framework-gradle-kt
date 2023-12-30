package cn.jaylong.snowflake

import cn.hutool.core.lang.Snowflake

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
class Snowflake(private var snowflake: Snowflake) {

    constructor(properties: SnowFlakeProperties) : this(
        Snowflake(
            properties.epochDate,
            properties.workerId,
            properties.dataCenterId,
            properties.useSystemClock,
            properties.timeOffset
        )
    )

    fun getWorkerId(id: Long): Long {
        return snowflake.getWorkerId(id)
    }

    fun getDataCenterId(id: Long): Long {
        return snowflake.getDataCenterId(id)
    }

    fun getGenerateDateTime(id: Long): Long {
        return snowflake.getGenerateDateTime(id)
    }

    @Synchronized
    fun nextId(): Long {
        return snowflake.nextId()
    }

    fun nextIdStr(): String {
        return snowflake.nextIdStr()
    }
}