package com.example.pruebatecnica.mvvm.common

import androidx.appcompat.app.AppCompatActivity

open class GenericActivity : AppCompatActivity() {

    var loadingDialog: LoadingScreenFragment?= null


    enum class LoadingView {
        SHOW, HIDE
    }

    fun loadingView(view: LoadingView) {
        when (view) {
            LoadingView.HIDE -> if (loadingDialog != null) {
                loadingDialog?.dismissAllowingStateLoss()
            }
            LoadingView.SHOW -> {
                loadingDialog = LoadingScreenFragment.display(supportFragmentManager)
                loadingDialog?.userVisibleHint = true
            }
        }
    }
}