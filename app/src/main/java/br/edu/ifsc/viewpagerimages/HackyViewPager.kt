package br.edu.ifsc.viewpagerimages

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

// Esta classe tem como objetivo resolver o problema de erros de zoom-in em view pagers
// ele deverá ser chamada onde o componente viewPager era criado, ou seja, está dentro do layout
// activity_main.xml
// então ao passar o dedo na horizontal trocará de página
class HackyViewPager : ViewPager {
    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!,
        attrs
    ) {
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return try {
            super.onInterceptTouchEvent(ev)
        } catch (e: IllegalArgumentException) { //            tragamento de exceções para não fechar o aplicativo no movimento de pinça diminuir om zoom
            false
        }
    }
}