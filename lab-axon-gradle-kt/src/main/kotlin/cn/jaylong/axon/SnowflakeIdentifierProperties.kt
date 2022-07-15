package cn.jaylong.axon

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
@ConfigurationProperties(prefix = SnowflakeIdentifierProperties.PREFIX)
data class SnowflakeIdentifierProperties(
    /**
     * 是否启用@ControllerAdvice
     */
    var enabled: Boolean
) {

    companion object {
        const val PREFIX: String = "lab.axon.snowflake-identifier"
    }


}