package com.rkpandey.kotlinrecyclerview.presenters

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rkpandey.kotlinrecyclerview.model.ModelObjectProtocol
import kotlinx.android.synthetic.main.activity_main.*


class ListPresenterAdapter(
    private val context: Context
)
    : RecyclerView.Adapter<ListPresenterAdapter.ViewHolder>() {
    private val TAG = "list adapter"
    public var list: List<ModelObjectProtocol>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // Returns the total count of items in the list
    override fun getItemCount() = list?.size ?: 0

    override fun getItemViewType(position: Int): Int {
        list?.let { it ->
            val item = it[position]
            val className = item::class.java.simpleName
            val xib = XibLoader.xib(className)
            xib?.let { it ->
                val xml = it.get("xml") as? String
                xml?.let {
                    return LayoutCache.layoutId(xml) ?: 0
                }
            }
        }
        return 0
    }

    // Usually involves inflating a layout from XML and returning the holder - THIS IS EXPENSIVE
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")

        if (viewType != 0) {
            val presenterView = ObjectPresenterView(context)
            presenterView.inflate(viewType)
            presenterView.setLayoutParams(
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
            return ViewHolder(presenterView)
        } else {
            val presenterView = ObjectPresenterView(context)
            return ViewHolder(presenterView)
        }
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

class RecycleViewListPresenter(private val context: Context): ListPresenter() {
    private var recyclerViewAdapter = ListPresenterAdapter(context)
    public var recyclerView: RecyclerView? = null
        set(value) {
            field = value
            recyclerView?.adapter = recyclerViewAdapter
            recyclerView?.layoutManager = LinearLayoutManager(context)
        }

    override fun update(items: List<ModelObjectProtocol>?) {
        super.update(items)
        recyclerViewAdapter.list = items
    }
}