package com.app.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.NewInstanceFactory() {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                return ViewModel("custom value") as T
            }
        })[ViewModel::class.java]
        setContentView(R.layout.acitvity_main)
    }
}