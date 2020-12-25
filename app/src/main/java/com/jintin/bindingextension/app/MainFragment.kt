package com.jintin.bindingextension.app

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jintin.bindingextension.BindingFragment
import com.jintin.bindingextension.app.databinding.AdapterMainBinding
import com.jintin.bindingextension.app.databinding.FragmentMainBinding
import com.jintin.bindingextension.toBinding

class MainFragment : BindingFragment<FragmentMainBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = MainAdapter((1..100).map { "#$it" })
    }

    class MainAdapter(private val list: List<String>) :
        RecyclerView.Adapter<MainAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(parent.toBinding())
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount() = list.size

        class ViewHolder(private val binding: AdapterMainBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(data: String) {
                binding.name.text = data
            }
        }
    }
}