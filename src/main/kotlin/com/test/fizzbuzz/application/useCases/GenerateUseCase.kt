package com.test.fizzbuzz.application.useCases

import com.test.fizzbuzz.application.requests.GenerateRequest
import com.test.fizzbuzz.domain.FizzBuzz
import org.springframework.stereotype.Service

@Service
class GenerateUseCase {

    fun generate( request : GenerateRequest) : String {
        return FizzBuzz(request.int1, request.int2, request.limit, request.str1, request.str2).generate()
    }

}