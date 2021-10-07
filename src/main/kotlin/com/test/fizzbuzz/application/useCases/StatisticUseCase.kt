package com.test.fizzbuzz.application.useCases

import com.test.fizzbuzz.application.responses.StatResponse
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

import java.util.concurrent.ConcurrentMap


@Service
class StatisticUseCase {

    private var statMap: ConcurrentMap<String, Int>? = ConcurrentHashMap()

    fun increaseCount(request: String) {
        val count = statMap!![request]
        if (count == null) {
            statMap!![request] = 1
        } else {
            statMap!![request] = count + 1
        }
    }

    fun getAllStatistics(): Map<*, *>? {
        return statMap
    }

    fun getMostCallUri(): StatResponse? {
        return if (statMap!!.size == 0 ) {
            null
        } else {
            val most = statMap!!.entries.stream().sorted { t, t2 -> t2.value - t.value }.findFirst()
            var ret : StatResponse? = null
            most.ifPresent{ it ->
                ret = StatResponse(it.key, it.value)
            }
            ret
        }
    }
}