package com.jnetai.localpermit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jnetai.localpermit.databinding.ItemMainBinding
import com.jnetai.localpermit.model.Permit

class PermitAdapter(private val onClick: (Permit) -> Unit) : RecyclerView.Adapter<PermitAdapter.VH>() {
    var items: List<Permit> = emptyList()
    inner class VH(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(h: VH, pos: Int) {
        val item = items[pos]
        h.databinding.titleText.text = item.title
        h.databinding.subtitleText.text = item.type + " · " + item.status
        h.databinding.root.setOnClickListener { onClick(item) }
    }
}