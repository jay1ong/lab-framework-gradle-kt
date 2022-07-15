package cn.jaylong.data.jpa

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor

/**
 *
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/7/13
 * Url: <a href="https://jaylong.cn">https://jaylong.cn</a>
 */
interface BaseEntityGraphRepository<T, ID : java.io.Serializable> : EntityGraphJpaRepository<T, ID>,
    EntityGraphQuerydslPredicateExecutor<T>, EntityGraphJpaSpecificationExecutor<T>