package com.jnetai.localpermit

import android.app.Application
import com.jnetai.localpermit.data.LocalPermitDatabase

class LocalPermit : Application() {
    val database by lazy { LocalPermitDatabase.getInstance(this) }
}