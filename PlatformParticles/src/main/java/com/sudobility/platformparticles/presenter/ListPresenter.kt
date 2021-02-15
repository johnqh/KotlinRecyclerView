package com.sudobility.platformparticles.presenter

import com.sudobility.particleskit.interactor.ListInteractor
import com.sudobility.utilities.kvo.ObservingProtocol
import com.sudobility.particleskit.model.ModelObjectProtocol
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