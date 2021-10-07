package com.test.fizzbuzz.domain

class FizzBuzz( val int1: Int, val int2: Int, var limit: Int, val str1: String, val str2: String) {


    /**
     * Return the "ERROR" as string if any error in parameter, otherwise the fizzbuzz string.
     */
    fun generate() : String {
        // Control input param
        if (int1 <= 0 || int2 <= 0 || int2 == int1) {
            return ERROR
        }
        if (str1 == "" || str2 == "") {
            return ERROR
        }
        if (limit > MAX) {
            limit = MAX
        }
        return fizzBuzz()
    }

    fun fizzBuzz(): String {
        val multiple = int1 * int2;
        val array = mutableListOf<Any>()
        for (i in 1..limit) {
            if (i % multiple == 0) {
                array.add(str1 + str2)
            } else if (i % int1 == 0) {
                array.add(str1)
            } else if (i % int2 == 0) {
                array.add(str2)
            } else {
                array.add(i)
            }
        }
        return array.joinToString(",")
    }

    companion object {
        val ERROR = "ERROR"     // ERROR Return
        val MAX = 100           // Valeur MAX de limit
    }
}
