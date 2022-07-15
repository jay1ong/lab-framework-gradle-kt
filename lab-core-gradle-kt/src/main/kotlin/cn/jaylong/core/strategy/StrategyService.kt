package cn.jaylong.core.strategy

import cn.jaylong.core.enums.StrategyException
import cn.jaylong.core.exception.BizException
import lombok.SneakyThrows
import org.springframework.beans.factory.getBeansWithAnnotation
import org.springframework.context.ApplicationContext
import kotlin.reflect.KClass
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.starProjectedType
import kotlin.reflect.full.superclasses

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
@Suppress("UNCHECKED_CAST")
class StrategyService(private var map: Map<String, Any>) {

    constructor(context: ApplicationContext) : this(context.getBeansWithAnnotation<Strategy>())

    @SneakyThrows
    fun <T, I : IStrategy<T>?> getStrategy(clazz: KClass<*>, param: T): I {
        val iStrategyClass = IStrategy::class
        for (o in this.map.values) {
            val oClass = o::class
            if (oClass.superclasses.any { it.simpleName == clazz.simpleName }) {
                if (oClass.memberFunctions.any {
                        it.name == iStrategyClass.memberFunctions.toMutableList()[0].name &&
                                it.parameters.any { that -> that.type == param!!::class.starProjectedType }
                    } &&
                    (o as I)!!.match(param)) {
                    return o
                }
            }
        }
        throw BizException(StrategyException.STRATEGY_NOT_FOUND)
    }
}