package com.rkpandey.kotlinrecyclerview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(private val context: Context, private val contacts: List<Contact>)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private val TAG = "ContactAdapter"
//
//    // Usually involves inflating a layout from XML and returning the holder - THIS IS EXPENSIVE
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        Log.i(TAG, "onCreateViewHolder")
//        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false))
//    }

    // Returns the total count of items in the list
    override fun getItemCount() = contacts.size

//    // Involves populating data into the item through holder - NOT expensive
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Log.i(TAG, "onBindViewHolder at position $position")
//        val contact = contacts[position]
//        holder.bind(contact)
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bind(contact: Contact) {
//            itemView.tvName.text = contact.name
//            itemView.tvAge.text = "Age: ${contact.age}"
//            Glide.with(context).load(contact.imageUrl).into(itemView.ivProfile)
//        }
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // no need for a LayoutInflater instance—
        // the custom view inflates itself
        val itemView = CustomView(parent.context)
        // manually set the CustomView's size
        itemView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.customView.contact = contacts[position]
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val customView: CustomView

        init {
            customView = v as CustomView
        }
    }
}