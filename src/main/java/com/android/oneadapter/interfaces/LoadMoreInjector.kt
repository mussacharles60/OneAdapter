package com.android.oneadapter.interfaces

import android.view.View

/**
 * Created by Idan Atsmon on 19/11/2018.
 */
abstract class LoadMoreInjector : HolderInjector<Any>() {

    abstract fun visibleThreshold(): Int
    abstract fun onLoadMore(currentPage: Int)

    // there is no data for empty injector, so use empty implementation
    override fun onInject(data: Any, inflatedView: View) {}
}