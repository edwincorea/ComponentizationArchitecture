package com.componentizationarchitecture.eventTypes

/**
 * List of all events Views can emit
 */
sealed class UserInteractionEvent {
    object IntentTapRetry : UserInteractionEvent()
}