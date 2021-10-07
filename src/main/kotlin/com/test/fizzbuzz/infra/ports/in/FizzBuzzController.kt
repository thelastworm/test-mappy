package com.test.fizzbuzz.infra.ports.`in`

import com.test.fizzbuzz.application.requests.GenerateRequest
import com.test.fizzbuzz.application.useCases.GenerateUseCase
import com.test.fizzbuzz.application.useCases.StatisticUseCase
import com.test.fizzbuzz.application.responses.StatResponse
import io.micrometer.core.annotation.Timed
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("api/v1")
@ApiOperation("Fizz buzz Generator and statistics APIs")
class FizzBuzzController(val generateUseCase: GenerateUseCase, val statisticUseCase: StatisticUseCase) {

    @Timed
    @PostMapping("/fizzbuzz/convert/{int1}/{int2}/{limit}/{str1}/{str2}")
    @ApiOperation("Generate the fizzbuzz string, or ERROR if any parameter errors")
    fun calculate(@PathVariable int1 : Int, @PathVariable int2 : Int, @PathVariable limit : Int, @PathVariable str1 : String, @PathVariable str2 : String) : ResponseEntity<String> {
        val result = generateUseCase.generate(GenerateRequest( int1 = int1, int2 = int2, limit, str1, str2))
        return ResponseEntity.ok(result)
    }

    @GetMapping("/fizzbuzz/stats")
    @ApiOperation("Obtenir l'api la plus requeter et le nombre de requête")
    fun getStats() : ResponseEntity<StatResponse> {
        return ResponseEntity.ok(statisticUseCase.getMostCallUri())
    }
}