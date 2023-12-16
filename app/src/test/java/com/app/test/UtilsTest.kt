package com.app.test

import org.junit.Assert.*
import org.junit.Test

class UtilsTest {

    @Test
    fun `isPalindrome returns true`() {
        val utils = Utils()
        val result = utils.isPalindrome("level")
        assertEquals(true, result)
    }

    @Test
    fun `isPalindrome returns false`() {
        val utils = Utils()
        val result = utils.isPalindrome("hello")
        assertEquals(false, result)
    }

    @Test(expected = ArithmeticException::class)
    fun `divide by zero throws exception`() {
        val utils = Utils()
        val result = utils.divide(10, 0)
        assertEquals(0, result)
    }

}