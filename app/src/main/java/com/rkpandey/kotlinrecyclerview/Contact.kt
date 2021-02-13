package com.rkpandey.kotlinrecyclerview

import com.rkpandey.kotlinrecyclerview.model.ModelObjectProtocol

data class Contact(val name: String, val age: Int): ModelObjectProtocol {
    val imageUrl = "https://picsum.photos/150?random=$age"
}