package cn.jaylong.web.net

import cn.jaylong.core.exception.BizException
import cn.jaylong.web.enums.HttpException
import org.apache.http.Header
import org.apache.http.HttpEntity
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils
import java.io.IOException

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
internal interface IHttpRequest {
    fun getHttpUriRequest(url: String?, headers: List<Header?>?, params: Map<String?, Any?>?): HttpUriRequest?
    fun request(url: String?, headers: List<Header?>?, params: Map<String?, Any?>?): String? {
        val entityString: String
        val httpEntity: HttpEntity
        var response: CloseableHttpResponse? = null
        //创建http client请求对象
        val defaultRequestConfig = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000)
            .setConnectionRequestTimeout(5000).build()
        val httpClient = HttpClientBuilder.create().setDefaultRequestConfig(defaultRequestConfig).build()
        //执行请求
        return try {
            response = httpClient.execute(getHttpUriRequest(url, headers, params))
            //解析返回值
            httpEntity = response.entity
            entityString = EntityUtils.toString(httpEntity)
            entityString
        } catch (e: IOException) {
            e.printStackTrace()
            throw BizException(HttpException.HTTP_ERROR)
        } finally {
            try {
                httpClient.close()
                response?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}