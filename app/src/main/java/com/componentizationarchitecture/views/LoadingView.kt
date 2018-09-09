package com.componentizationarchitecture.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.componentizationarchitecture.R
import com.componentizationarchitecture.arch.UIView
import com.componentizationarchitecture.eventTypes.UserInteractionEvent

class LoadingView(container: ViewGroup) : UIView<UserInteractionEvent>(container) {
    override val view: View = LayoutInflater.from(container.context).inflate(R.layout.loading, container, false)
    init {
        container.addView(view)
    }
}
