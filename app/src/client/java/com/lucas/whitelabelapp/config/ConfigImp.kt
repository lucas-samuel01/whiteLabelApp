package com.lucas.whitelabelapp.config

import android.view.View
import javax.inject.Inject

class ConfigImp @Inject constructor():Config {
    override val addButtonVisibility: Int = View.GONE
}