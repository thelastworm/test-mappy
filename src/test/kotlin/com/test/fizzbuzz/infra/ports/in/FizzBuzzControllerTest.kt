package com.test.fizzbuzz.infra.ports.`in`

import com.test.fizzbuzz.FizzbuzzApplication
import com.test.fizzbuzz.application.useCases.GenerateUseCase
import com.test.fizzbuzz.application.useCases.StatisticUseCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@SpringBootTest(classes = [FizzbuzzApplication::class])
internal class FizzBuzzControllerTest {

    private lateinit var fizzBuzzController: FizzBuzzController
    private lateinit var mock: MockMvc

    @BeforeEach
    fun setup() {
        MockitoAnnotations.initMocks(this)
        fizzBuzzController = FizzBuzzController(GenerateUseCase(), StatisticUseCase())
        mock = MockMvcBuilders.standaloneSetup(fizzBuzzController)
                .build()
    }

    @Test
    fun should_validate_3_5_limit_16() {
        mock.perform(MockMvcRequestBuilders.post("/api/v1/fizzbuzz/convert/3/5/16/fizz/buzz")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().string("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16"));
    }

    @Test
    fun should_validate_3_5_limit_10() {
        mock.perform(MockMvcRequestBuilders.post("/api/v1/fizzbuzz/convert/3/5/10/fizz/buzz")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().string("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz"));
    }

    @Test
    fun should_not_validate_minus3_5_limit_16() {
        mock.perform(MockMvcRequestBuilders.post("/api/v1/fizzbuzz/convert/-3/5/16/fizz/buzz")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().string("ERROR"));
    }
}