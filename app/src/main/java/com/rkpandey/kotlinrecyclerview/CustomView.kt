package com.rkpandey.kotlinrecyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class CustomView(
    context: Context?,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : RelativeLayout(context, attrs, defStyleAttr, defStyleRes) {
    public var contact: Contact? = null
        set(value) {
            field = value

            contact?.let { contact ->
                tvName.text = contact.name
                tvAge.text = "Age: ${contact.age}"
//                Glide.with(context).load(contact.imageUrl).into(ivProfile)
            }
        }
    private val ivProfile: ImageView
    private val tvName: TextView
    private val tvAge: TextView

    // override all constructors to ensure custom logic runs in all cases
    constructor(context: Context?) : this(context, null) {}
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0
    ) {
    }

    init {

        // put all custom logic in this constructor, which always runs
        inflate(getContext(), R.layout.item_contact, this)
        ivProfile = findViewById<View>(R.id.ivProfile) as ImageView
        tvName = findViewById<View>(R.id.tvName) as TextView
        tvAge = findViewById<View>(R.id.tvAge) as TextView
    }
}