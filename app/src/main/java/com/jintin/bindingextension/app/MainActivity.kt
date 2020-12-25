package com.jintin.bindingextension.app

import android.os.Bundle
import com.jintin.bindingextension.BindingActivity
import com.jintin.bindingextension.app.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.label.setText(R.string.activity_label)
    }
}