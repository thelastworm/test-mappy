package com.test.fizzbuzz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class FizzbuzzApplication

fun main(args: Array<String>) {
	runApplication<FizzbuzzApplication>(*args)
}
