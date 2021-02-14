package com.rkpandey.kotlinrecyclerview.interactors

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rkpandey.kotlinrecyclerview.kvo.NSObject
import com.sudobility.particleskit.model.ModelObjectProtocol

class ListInteractor: NSObject(), ModelObjectProtocol {
    public var list : List<ModelObjectProtocol>?
        get() = value("list") as? List<ModelObjectProtocol>
        set(value) = set(value, key = "list")
}