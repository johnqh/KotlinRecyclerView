package com.rkpandey.kotlinrecyclerview.presenters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rkpandey.kotlinrecyclerview.R
import com.sudobility.particleskit.model.ModelObjectProtocol

class RecycleViewListPresenterAdapter(
    private val context: Context
)
    : RecyclerView.Adapter<RecycleViewListPresenterAdapter.ViewHolder>() {
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
            val view = itemView as? ObjectPresenterView
            view?.let { view ->
                val className = item::class.java.simpleName
                val xib = XibLoader.xib(className)
                xib?.let { it ->
                    val presenterClass = it.get("presenter") as? String
                    presenterClass?.let {
                        val presenter = Class.forName(presenterClass).newInstance() as? ObjectPresenter
                        view.presenter = presenter
                    }
                }
                view.model = item
            }
        }
    }
}