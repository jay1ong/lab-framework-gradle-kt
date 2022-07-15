package cn.jaylong.web.net

import cn.hutool.core.convert.Convert
import cn.hutool.core.util.CharsetUtil
import cn.hutool.http.ContentType
import com.alibaba.fastjson.JSON
import org.apache.http.Header
import org.apache.http.HttpEntity
import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.entity.StringEntity
import org.apache.http.message.BasicNameValuePair
import java.net.URI

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
internal class HttpPost : IHttpRequest {

    override fun getHttpUriRequest(
        url: String?,
        headers: List<Header?>?,
        params: Map<String?, Any?>?
    ): HttpUriRequest {
        var entity: HttpEntity = StringEntity(JSON.toJSONString(params), CharsetUtil.UTF_8)
        //声明请求方式
        val httpPost = HttpPost()
        httpPost.uri = url?.let { URI.create(it) }
        httpPost.setHeader("Content-Type", ContentType.JSON.value)
        //设置Content-Type
        if (headers!!.isNotEmpty()) {
            for (header in headers) {
                httpPost.addHeader(header)
            }
            //设置请求 参数的编码格式
            val headerOptional = headers.stream().filter { it?.name == "Content-Type" }
                .findFirst()
            if (headerOptional.isPresent) {
                val contentType = headerOptional.get().value
                if (contentType == ContentType.FORM_URLENCODED.value) {
                    httpPost.setHeader("Content-Type", ContentType.FORM_URLENCODED.value)
                    val nameValuePairList: MutableList<NameValuePair> = ArrayList()
                    for (key in params!!.keys) {
                        nameValuePairList.add(
                            BasicNameValuePair(
                                key, Convert.toStr(
                                    params[key]
                                )
                            )
                        )
                    }
                    entity = UrlEncodedFormEntity(nameValuePairList, "UTF-8")
                }
            }
        }
        //声明携带参数
        httpPost.entity = entity
        return httpPost
    }
}