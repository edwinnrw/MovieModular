package com.edwinnurwansyah.core.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.edwinnurwansyah.core.util.ViewLayout

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutIfDefined()
    }

    private fun setLayoutIfDefined() {
        val layoutResId = getViewLayoutResId()
        setContentView(layoutResId)

    }

    protected open fun getViewLayoutResId(): Int {
        val layout = javaClass.annotations.find { it is ViewLayout } as? ViewLayout
        return layout?.value ?: View.NO_ID
    }
}
