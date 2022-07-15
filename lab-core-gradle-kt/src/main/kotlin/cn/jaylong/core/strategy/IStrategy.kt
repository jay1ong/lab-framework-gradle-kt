package cn.jaylong.core.strategy

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
interface IStrategy<T> {

    fun match(param: T): Boolean

}