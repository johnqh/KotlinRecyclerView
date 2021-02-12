package com.rkpandey.kotlinrecyclerview.presenters

import android.R
import android.view.View
import android.widget.RelativeLayout
import android.content.Context
import android.util.AttributeSet
import com.rkpandey.kotlinrecyclerview.model.ModelObjectProtocol


class ObjectPresenterView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : RelativeLayout(context, attrs, defStyleAttr, defStyleRes) {
    public var model: ModelObjectProtocol? = null
        set(value) {
            field = value
            presenter?.model = model
        }

    public var presenter: ObjectPresenter?  = null
        set(value) {
            presenter?.model = null
            field = value
            presenter?.model = model
        }

    // override all constructors to ensure custom logic runs in all cases
    constructor(context: Context?) : this(context, null) {}
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0) {}

    init {
        // put all custom logic in this constructor, which always runs
    }

    public fun inflate(`id`: Int) {
        inflate(getContext(), id, this)
    }
}