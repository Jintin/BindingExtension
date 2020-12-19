package com.jintin.bindingextension.app

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jintin.bindingextension.BindingFragment
import com.jintin.bindingextension.BindingHolder
import com.jintin.bindingextension.app.databinding.AdapterMainBinding
import com.jintin.bindingextension.app.databinding.FragmentMainBinding

class MainFragment : BindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = MainAdapter((1..100).map { "#$it" })
    }

    class MainAdapter(private val list: List<String>) :
        RecyclerView.Adapter<MainAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(parent)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount() = list.size

        class ViewHolder(parent: ViewGroup) :
            BindingHolder<AdapterMainBinding>(parent, AdapterMainBinding::inflate) {

            fun bind(data: String) {
                binding.name.text = data
            }
        }
    }
}