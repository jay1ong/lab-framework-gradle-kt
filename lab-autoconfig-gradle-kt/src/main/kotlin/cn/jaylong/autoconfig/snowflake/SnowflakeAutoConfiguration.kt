package cn.jaylong.autoconfig.snowflake

import cn.jaylong.snowflake.SnowFlakeProperties
import cn.jaylong.snowflake.Snowflake
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties(SnowFlakeProperties::class)
@ConditionalOnClass(cn.jaylong.snowflake.Snowflake::class)
open class SnowflakeAutoConfiguration {
    @Autowired
    private lateinit var properties: SnowFlakeProperties

    @Bean
    @ConditionalOnMissingBean
    open fun snowflake(): Snowflake? {
        return Snowflake(properties)
    }
}