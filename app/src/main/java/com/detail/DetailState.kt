package com.detail

import com.ComponentType
import com.vro.state.VROState

data class DetailState(
    val componentType: ComponentType
) : VROState {
    companion object {
        val INITIAL = DetailState(
            componentType = ComponentType.BUTTON
        )
    }
}