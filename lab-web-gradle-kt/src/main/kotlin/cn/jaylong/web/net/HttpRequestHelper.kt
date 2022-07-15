package cn.jaylong.web.net

import cn.hutool.http.Method
import org.apache.http.Header

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
class HttpRequestHelper {

    companion object {
        private val httpRequestMap: MutableMap<String, IHttpRequest> = HashMap()

        init {
            httpRequestMap[Method.POST.name] = HttpPost()
            httpRequestMap[Method.GET.name] = HttpGet()
        }

        fun request(method: String, url: String?, headers: List<Header?>?, params: Map<String?, Any?>?): String? {
            return httpRequestMap[method]!!.request(url, headers, params)
        }
    }
}