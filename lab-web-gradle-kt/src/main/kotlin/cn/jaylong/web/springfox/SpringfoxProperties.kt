package cn.jaylong.web.springfox

import lombok.Data
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
@Data
@ConfigurationProperties(prefix = SpringfoxProperties.PREFIX)
data class SpringfoxProperties(
    /**
     * 是否启用swagger
     */
    var enabled: Boolean = true,

    /**
     * 是否启用swagger security
     */
    var enableSecurity: Boolean = false
) {
    companion object {
        const val PREFIX = "lab.springfox"
    }
}