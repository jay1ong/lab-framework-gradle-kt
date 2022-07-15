package cn.jaylong.web.controller

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
@ConfigurationProperties(prefix = RestControllerProperties.PREFIX)
data class RestControllerProperties(
    /**
     * 是否启用@ControllerAdvice
     */
    var enabled: Boolean = true,
    var excludePackages: Set<String> = HashSet(),
    var excludeClasses: Set<String> = HashSet(),
    var excludePaths: Set<String> = HashSet(),
) {


    companion object {
        const val PREFIX = "lab.web.advice"
    }
}