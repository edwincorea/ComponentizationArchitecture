package com.componentizationarchitecture.presenters

import com.componentizationarchitecture.arch.Presenter
import com.componentizationarchitecture.arch.UIView
import com.componentizationarchitecture.eventTypes.ScreenStateEvent
import com.componentizationarchitecture.eventTypes.UserInteractionEvent
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

class SuccessPresenter<SSE : ScreenStateEvent, UIE : UserInteractionEvent>(
    uiView: UIView<UIE>,
    screenStateEvent: Observable<SSE>,
    destroyObservable: Observable<Unit>
) : Presenter<SSE, UIE>(uiView, screenStateEvent, destroyObservable) {

    init {
        screenStateEvent
            .takeUntil(destroyObservable)
            .subscribeBy(
                onNext = {
                    when (it) {
                        ScreenStateEvent.Loading -> {
                            uiView.hide()
                        }
                        ScreenStateEvent.Loaded -> {
                            uiView.show()
                        }
                        ScreenStateEvent.Error -> {
                            uiView.hide()
                        }
                    }
                }
            )
    }
}