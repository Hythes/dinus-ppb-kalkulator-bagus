package com.example.kalkulatorbaru.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulatorbaru.databinding.RvHistoryBinding
import com.example.kalkulatorbaru.model.MainModel

class MainAdapter(private val dataSet: List<MainModel>?) :

    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    lateinit var binding: RvHistoryBinding

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
        }
        fun bind(mainModel: MainModel?) {
            binding.tvInput1.text = mainModel?.input1
            binding.tvInput2.text = mainModel?.operator
            binding.tvInput3.text = mainModel?.input2
            binding.tvInput4.text = mainModel?.hasil
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        Log.d("AdapterOpened","WOOOW")
        binding = RvHistoryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding.root)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bind(dataSet?.get(position))

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet?.size ?: 0

}
