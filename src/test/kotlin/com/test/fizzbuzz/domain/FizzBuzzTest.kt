package com.test.fizzbuzz.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class FizzBuzzTest {

    @Test
    fun should_validate_3_5_limit_16() {
        val expect = "1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16"
        val answer = FizzBuzz(3, 5, 16, "fizz", "buzz").generate()
        assertEquals(expect, answer)
    }

    @Test
    fun should_validate_3_5_limit_10() {
        val expect = "1,2,fizz,4,buzz,fizz,7,8,fizz,buzz"
        val answer = FizzBuzz(3, 5, 10, "fizz", "buzz").generate()
        assertEquals(expect, answer)
    }

    @Test
    fun should_validate_3_5_limit_8() {
        val expect = "1,2,fizz,4,buzz,fizz,7,8"
        val answer = FizzBuzz(3, 5, 8, "fizz", "buzz").generate()
        assertEquals(expect, answer)
    }

    @Test
    fun should_not_validate_negative_int1() {
        val answer = FizzBuzz(-3, 5, 8, "fizz", "buzz").generate()
        assertEquals(FizzBuzz.ERROR, answer)
    }

    @Test
    fun should_not_validate_negative_int2() {
        val answer = FizzBuzz(3, -5, 8, "fizz", "buzz").generate()
        assertEquals(FizzBuzz.ERROR, answer)
    }

    @Test
    fun should_not_validate_empty_str1() {
        val answer = FizzBuzz(3, 5, 8, "", "buzz").generate()
        assertEquals(FizzBuzz.ERROR, answer)
    }

    @Test
    fun should_not_validate_empty_str2() {
        val answer = FizzBuzz(3, 5, 8, "fizz", "").generate()
        assertEquals(FizzBuzz.ERROR, answer)
    }

    @Test
    fun should_not_validate_when_int1_is_equal_to_int2() {
        val answer = FizzBuzz(3, 3, 8, "fizz", "buzz").generate()
        assertEquals(FizzBuzz.ERROR, answer)
    }
}