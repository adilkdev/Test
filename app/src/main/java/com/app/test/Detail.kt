package com.app.test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Detail {

    suspend fun getMessage(): String {
        delay(10000)
        return "Hello World"
    }

    suspend fun getMessageOnMain(): String {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
        }
        return "Hello World"
    }

}