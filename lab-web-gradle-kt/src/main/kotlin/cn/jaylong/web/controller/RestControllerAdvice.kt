package cn.jaylong.web.controller

import cn.jaylong.core.exception.BizException
import cn.jaylong.core.net.ApiMessage
import cn.jaylong.web.OriginResponse
import com.fasterxml.jackson.databind.ObjectMapper
import lombok.SneakyThrows
import org.axonframework.modelling.command.AggregateNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.core.MethodParameter
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.util.AntPathMatcher
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
import java.time.LocalDateTime
import java.util.function.Consumer

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
@org.springframework.web.bind.annotation.RestControllerAdvice
class RestControllerAdvice(
    private var properties: RestControllerProperties,
    private var objectMapper: ObjectMapper
) : ResponseBodyAdvice<Any?> {

    private val log = LoggerFactory.getLogger(this.javaClass)

    private val matcher = AntPathMatcher()

    @ExceptionHandler(BizException::class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    fun bizException(ex: BizException, request: WebRequest): ResponseEntity<*> {
        log.error(ex.message)
        ex.printStackTrace()
        return ResponseEntity.ok(
            ApiMessage(
                code = ex.code,
                timestamp = LocalDateTime.now(),
                message = ex.message,
                description = request.getDescription(false)
            )
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    fun globalExceptionHandler(ex: Exception, request: WebRequest): ResponseEntity<*> {
        log.error(ex.message)
        ex.printStackTrace()
        return ResponseEntity.ok(
            ApiMessage(
                code = "11000",
                timestamp = LocalDateTime.now(),
                message = ex.message,
                description = request.getDescription(false)
            )
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidExceptionHandler(
        ex: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<*> {
        log.error(ex.message)
        ex.printStackTrace()
        val result = ex.bindingResult
        val fieldErrors = result.fieldErrors
        val stringBuilder = StringBuilder()
        fieldErrors.forEach(Consumer {
            stringBuilder
                .append("(")
                .append(it.field)
                .append(")")
                .append(it.defaultMessage)
                .append(";")
        })
        return ResponseEntity.ok(
            ApiMessage(
                code = "11001",
                timestamp = LocalDateTime.now(),
                message = stringBuilder.toString(),
                description = request.getDescription(false)
            )
        )
    }

    @ExceptionHandler(AggregateNotFoundException::class)
    fun aggregateNotFoundException(ex: AggregateNotFoundException, request: WebRequest): ResponseEntity<*> {
        log.error(ex.message)
        ex.printStackTrace()
        return ResponseEntity.ok(
            ApiMessage(
                code = "11002",
                timestamp = LocalDateTime.now(),
                message = "指定的聚合不存在:" + ex.message,
                description = request.getDescription(false)
            )
        )
    }

    override fun supports(
        returnType: MethodParameter,
        converterType: Class<out HttpMessageConverter<*>?>
    ): Boolean {
        return filter(returnType)
    }

    @SneakyThrows
    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>?>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        if (properties.excludePaths.stream().anyMatch {
                matcher.match(
                    it,
                    request.uri.path
                )
            }) {
            return body
        }
        if (body is ApiMessage) {
            return body
        }
        val message = ApiMessage(
            code = "200",
            timestamp = LocalDateTime.now(),
            data = body ?: "成功"
        )
        response.headers["Content-Type"] = "application/json;charset=utf-8"
        return if (body is String) objectMapper.writeValueAsString(message) else message
    }

    private fun filter(returnType: MethodParameter): Boolean {
        val declaringClass = returnType.declaringClass
        val method = returnType.method ?: return false
        val excludePackages = properties.excludePackages
        if (excludePackages.isNotEmpty() && excludePackages.stream().anyMatch {
                matcher.match(
                    it,
                    declaringClass.getPackage().name
                )
            }) {
            return false
        }
        val excludeClasses = properties.excludeClasses
        if (excludeClasses.isNotEmpty() && excludeClasses.stream().anyMatch {
                matcher.match(
                    it,
                    declaringClass.name
                )
            }) {
            return false
        }
        if (declaringClass.isAnnotationPresent(OriginResponse::class.java)) {
            return false
        }
        return if (method.isAnnotationPresent(OriginResponse::class.java)) {
            false
        } else properties.enabled
    }
}