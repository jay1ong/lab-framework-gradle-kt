package cn.jaylong.autoconfig.core

import cn.jaylong.core.strategy.StrategyService
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.ApplicationContext
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
@ConditionalOnClass(StrategyService::class)
@AllArgsConstructor
open class StrategyAutoConfiguration {
    @Autowired
    private lateinit var context: ApplicationContext
    @Bean
    @ConditionalOnMissingBean
    open fun service(): StrategyService {
        return StrategyService(context)
    }
}