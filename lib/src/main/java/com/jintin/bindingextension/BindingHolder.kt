package com.jintin.bindingextension

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class BindingHolder<V : ViewBinding>(
    val binding: V
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
        provider: (LayoutInflater, ViewGroup?, Boolean) -> V
    ) : this(provider.invoke(LayoutInflater.from(parent.context), parent, false))

}