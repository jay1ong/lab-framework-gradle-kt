package cn.jaylong.autoconfig.web

import cn.jaylong.web.controller.RestControllerAdvice
import cn.jaylong.web.controller.RestControllerProperties
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
@Configuration
@EnableConfigurationProperties(RestControllerProperties::class)
@ConditionalOnWebApplication
@ConditionalOnClass(
    RestControllerAdvice::class
)
open class RestControllerAutoConfiguration {
    @Autowired
    private lateinit var properties: RestControllerProperties
    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = RestControllerProperties.PREFIX, value = ["enabled"], matchIfMissing = true)
    open fun restControllerAdvice(): RestControllerAdvice {
        return RestControllerAdvice(properties, objectMapper)
    }
}