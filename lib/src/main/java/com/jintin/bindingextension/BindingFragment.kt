package com.jintin.bindingextension

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class BindingFragment<V : ViewBinding> : Fragment() {

    private var _binding: V? = null

    val binding: V = _binding
        ?: throw RuntimeException("Should only use binding after onCreateView and before onDestroyView")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return getBinding(inflater, container)
            .also {
                _binding = it
            }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}