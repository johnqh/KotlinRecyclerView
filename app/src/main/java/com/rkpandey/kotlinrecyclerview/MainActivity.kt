package com.rkpandey.kotlinrecyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.rkpandey.kotlinrecyclerview.interactors.ListInteractor
import com.rkpandey.kotlinrecyclerview.presenters.ListPresenter
import com.rkpandey.kotlinrecyclerview.presenters.RecycleViewListPresenter
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    val contactPresenter = RecycleViewListPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate")

        contactPresenter.recyclerView = rvContacts
        var listInteractor = ListInteractor()

        val model = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        model.getContacts().observe(this, Observer { contacts ->
            // Update the UI with the new contacts
            listInteractor.list = contacts
        })
        contactPresenter.listInteractor = listInteractor


        model.getIsRefreshing().observe(this, Observer { isRefreshing ->
            swipeContainer.isRefreshing = isRefreshing
        })

        swipeContainer.setOnRefreshListener {
            model.fetchNewContact()
        }
    }
}
