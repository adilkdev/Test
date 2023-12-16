package com.app.test

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class ParameterizedUtilsTest(private val input: String, private val expected: Boolean) {

    companion object {
        @JvmStatic
        @Parameters(name = "{index} : {0} is palindrome - {1}")
        fun data(): List<Array<Any>> = listOf(
            arrayOf("hello", false),
            arrayOf("level", true),
            arrayOf("a", true),
            arrayOf(" ", true),
        )
    }

    @Test
    fun test() {
        val utils = Utils()
        val result = utils.isPalindrome(input)
        assertEquals(expected, result)
    }

}