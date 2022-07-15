package cn.jaylong.autoconfig.web

import cn.jaylong.web.springfox.SpringfoxProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.SecurityReference
import springfox.documentation.service.SecurityScheme
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(
    SpringfoxProperties::class
)
open class SpringFoxAutoConfiguration {
    @Autowired
    private lateinit var properties: SpringfoxProperties

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = SpringfoxProperties.PREFIX, value = ["enabled"], matchIfMissing = true)
    open fun api(): Docket {
        val docket = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any()) //不显示错误的接口地址
            //错误路径不监控
            .paths(PathSelectors.regex("/error.*").negate())
            .paths(PathSelectors.regex("/.*"))
            .build()
        if (properties.enableSecurity) {
            docket.securityContexts(listOf(securityContext()))
                .securitySchemes(listOf<SecurityScheme>(apiKey()))
        }
        return docket
    }

    private fun apiKey(): ApiKey {
        return ApiKey("JWT", "Authorization", "header")
    }

    private fun securityContext(): SecurityContext {
        return SecurityContext.builder().securityReferences(defaultAuth()).build()
    }

    private fun defaultAuth(): List<SecurityReference> {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes = arrayOfNulls<AuthorizationScope>(1)
        authorizationScopes[0] = authorizationScope
        return listOf(SecurityReference("JWT", authorizationScopes))
    }
}