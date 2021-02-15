package com.sudobility.platformparticles.presenter

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sudobility.particleskit.model.ModelObjectProtocol


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