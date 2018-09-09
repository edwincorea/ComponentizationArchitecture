package com.componentizationarchitecture.eventTypes

/**
 * List of all events this Screen can emit
 */
sealed class ScreenStateEvent {
    object Loading : ScreenStateEvent()
    object Loaded : ScreenStateEvent()
    object Error : ScreenStateEvent()
}