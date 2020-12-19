package com.jintin.bindingextension.app

import android.os.Bundle
import android.view.View
import com.jintin.bindingextension.BindingFragment
import com.jintin.bindingextension.app.databinding.FragmentMainBinding

class MainFragment : BindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            binding.button.setText(R.string.fragment_label)
        }
    }
}