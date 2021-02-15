package com.sudobility.particleskit.interactor

import com.sudobility.utilities.kvo.NSObject
import com.sudobility.particleskit.model.ModelObjectProtocol

class ListInteractor: NSObject(), ModelObjectProtocol {
    public var list : List<ModelObjectProtocol>?
        get() = value("list") as? List<ModelObjectProtocol>
        set(value) = set(value, key = "list")
}