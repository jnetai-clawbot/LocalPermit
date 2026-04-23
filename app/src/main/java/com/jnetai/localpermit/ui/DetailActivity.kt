package com.jnetai.localpermit.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jnetai.localpermit.LocalPermit
import com.jnetai.localpermit.databinding.ActivityDetailBinding
import com.jnetai.localpermit.model.Permit
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val app get() = application as LocalPermit
    private var item: Permit? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        val itemId = intent.getLongExtra("item_id", -1)
        if (itemId == -1L) { finish(); return }
        
        lifecycleScope.launch {
            item = app.database.dao().getPermit(itemId)
            item?.let { displayDetails(it) }
        }
    }
    
    private fun displayDetails(item: Permit) {
        binding.titleText.text = item.title
        binding.detailText.text = item.toString()
    }

    override fun onSupportNavigateUp(): Boolean { finish(); return true }
}