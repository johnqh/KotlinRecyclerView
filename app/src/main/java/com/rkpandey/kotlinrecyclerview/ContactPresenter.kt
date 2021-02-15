package com.rkpandey.kotlinrecyclerview

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sudobility.platformparticles.presenter.ObjectPresenter

class ContactPresenter: ObjectPresenter() {
    private var ivProfile: ImageView? = null
    private var tvName: TextView? = null
    private var tvAge: TextView? = null

    private val contact: Contact?
        get() {
            return model as? Contact
        }

    override fun getSubviews() {
        ivProfile = view?.findViewById(R.id.ivProfile)
        tvName = view?.findViewById(R.id.tvName)
        tvAge = view?.findViewById(R.id.tvAge)
    }

    override fun updateSelf() {
        tvName?.text = contact?.name
        tvAge?.text = "Age: ${contact?.age}"
        if (context != null && ivProfile != null) {
            Glide.with(context!!).load(contact?.imageUrl).into(ivProfile!!)
        }
    }
}