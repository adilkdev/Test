package com.app.test

class Utils {

    fun isPalindrome(input: String) : Boolean {
        var i = 0
        var j = input.length - 1
        while(i < j) {
            if (input[i++] != input[j--]) return false
        }
        return true;
    }

    fun divide(op1: Int, op2: Int)  = op1 / op2

}