package cn.jaylong.web.net

import cn.hutool.http.Method
import org.apache.http.Header
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.client.methods.RequestBuilder

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
internal class HttpGet : IHttpRequest {
    override fun getHttpUriRequest(url: String?, headers: List<Header?>?, params: Map<String?, Any?>?): HttpUriRequest {
        //声明请求方式
        //设置content-Type
        return RequestBuilder.create(Method.GET.name)
            .setUri(url)
            .build()
    }
}