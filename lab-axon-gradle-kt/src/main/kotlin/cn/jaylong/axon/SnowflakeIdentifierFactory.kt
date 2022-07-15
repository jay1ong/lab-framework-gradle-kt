package cn.jaylong.axon

import cn.hutool.extra.spring.SpringUtil
import cn.jaylong.snowflake.Snowflake
import org.axonframework.common.IdentifierFactory

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
class SnowflakeIdentifierFactory : IdentifierFactory() {

    override fun generateIdentifier(): String? {
        val snowflake = SpringUtil.getBean(Snowflake::class.java)
        return snowflake.nextIdStr()
    }
}