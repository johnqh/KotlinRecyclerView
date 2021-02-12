package com.rkpandey.kotlinrecyclerview.presenters

import com.rkpandey.kotlinrecyclerview.interactors.ListInteractor
import com.rkpandey.kotlinrecyclerview.kvo.ObservingProtocol
import com.rkpandey.kotlinrecyclerview.model.ModelObjectProtocol
import java.util.*

open class ListPresenter: ObservingProtocol {
    public override var _uuid: UUID? = null

    public var listInteractor: ListInteractor? = null
        set(value: ListInteractor?) {
            val old = listInteractor
            field = value
            changeObservation(old, value, "list") {_, _, _ ->
                update(value?.list)
            }
        }

    open fun update(items: List<ModelObjectProtocol>?) {

    }
}