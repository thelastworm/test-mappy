package com.test.fizzbuzz.infra.filter

import com.test.fizzbuzz.application.useCases.StatisticUseCase
import org.apache.catalina.connector.RequestFacade
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@Component
@Order(1)
class EndpointFilter( val statisticUseCase: StatisticUseCase) : Filter {

    override fun doFilter(servletRequest: ServletRequest?, servletResponse: ServletResponse?, chain: FilterChain?) {
        val uri = (servletRequest as RequestFacade).requestURI
        if (uri.contains("/api/")) {
            statisticUseCase.increaseCount(uri)
        }
       chain?.doFilter(servletRequest, servletResponse)
    }

}