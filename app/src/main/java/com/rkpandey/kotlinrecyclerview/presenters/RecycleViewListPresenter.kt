package com.rkpandey.kotlinrecyclerview.presenters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rkpandey.kotlinrecyclerview.R
import com.rkpandey.kotlinrecyclerview.model.ModelObjectProtocol
import kotlinx.android.synthetic.main.activity_main.*



class RecycleViewListPresenter(private val context: Context): ListPresenter() {
    private var recyclerViewAdapter = RecycleViewListPresenterAdapter(context)
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