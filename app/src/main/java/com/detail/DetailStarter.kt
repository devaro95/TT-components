package com.detail

import com.ComponentType
import com.vro.navstarter.VRONavStarter

sealed class DetailStarter: VRONavStarter {
    data class Initialize(val componentType: ComponentType) : DetailStarter()
}