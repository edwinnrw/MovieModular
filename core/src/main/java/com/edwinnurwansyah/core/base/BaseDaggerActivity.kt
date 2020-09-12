package com.edwinnurwansyah.core.base

import android.os.Bundle


abstract class BaseDaggerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        injectComponent()
        super.onCreate(savedInstanceState)
    }

    protected abstract fun injectComponent()
}
