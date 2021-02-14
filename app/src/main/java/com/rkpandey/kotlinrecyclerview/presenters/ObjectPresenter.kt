package com.rkpandey.kotlinrecyclerview.presenters

import android.view.ViewGroup
import android.widget.RelativeLayout
import com.rkpandey.kotlinrecyclerview.model.ModelObjectProtocol

open class ObjectPresenter {
    public var view: ViewGroup? = null
        set(value) {
            field = value
            getSubviews()
            update()
        }
    public var model: ModelObjectProtocol? = null
        set(value) {
            field = value
            update()
        }

    open fun getSubviews() {
    }

    open fun update() {
        if (view != null && model != null) {
            updateSelf()
        }
    }

    open fun updateSelf() {

    }
}