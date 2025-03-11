package com.sample

import com.ComponentType
import com.vro.event.VROEvent

sealed class SampleEvents : VROEvent {
    data class Detail(val componentType: ComponentType) : SampleEvents()
}