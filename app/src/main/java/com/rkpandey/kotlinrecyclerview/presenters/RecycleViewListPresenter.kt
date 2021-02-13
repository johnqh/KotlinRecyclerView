package com.rkpandey.kotlinrecyclerview.presenters

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rkpandey.kotlinrecyclerview.model.ModelObjectProtocol


class ListPresenterAdapter(
    private val context: Context,
    private val list: List<ModelObjectProtocol>?
)
    : RecyclerView.Adapter<ListPresenterAdapter.ViewHolder>() {
    private val TAG = "list adapter"

    // Returns the total count of items in the list
    override fun getItemCount() = list?.size ?: 0

    override fun getItemViewType(position: Int): Int {
        list?.let {
            val item = it[position]
            return LayoutCache.layoutId(item::class.java.simpleName) ?: 0
        }
        return 0
    }

    // Usually involves inflating a layout from XML and returning the holder - THIS IS EXPENSIVE
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")

        val presenterView = ObjectPresenterView(context)
        presenterView.inflate(viewType)
        presenterView.setLayoutParams(
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
        return ViewHolder(presenterView)
    }

    // Involves populating data into the item through holder - NOT expensive
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder at position $position")
        list?.let {
            val item = it[position]
            holder.bind(item)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ModelObjectProtocol) {
            (itemView as? ObjectPresenterView)?.model = item
        }
    }
}

class RecycleViewListPresenter: ListPresenter() {
    override fun update(items: List<ModelObjectProtocol>?) {
        super.update(items)
    }
}