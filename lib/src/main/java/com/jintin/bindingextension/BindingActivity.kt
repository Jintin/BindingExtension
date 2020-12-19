package com.jintin.bindingextension

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

open class BindingActivity<V : ViewBinding>(
    private val bindingProvider: (LayoutInflater) -> V
) : AppCompatActivity() {

    lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingProvider.invoke(layoutInflater)
        setContentView(binding.root)
    }
}