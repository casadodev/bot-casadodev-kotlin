package com.casadodev.features

import com.github.philippheuer.events4j.simple.SimpleEventHandler
import com.github.twitch4j.chat.events.channel.SubscriptionEvent

class ChannelNotificationOnSubscription(eventHandler: SimpleEventHandler) {
    init {
        eventHandler.onEvent(SubscriptionEvent::class.java, this::onSubscription)
    }

    private fun onSubscription(event: SubscriptionEvent) {
        val message = when {
            event.months <= 1 -> newSubscription(
                event
            )
            else -> resubscription(event)
        }
        event.twitchChat.sendMessage(event.channel.name, message)
    }

    private fun newSubscription(event: SubscriptionEvent): String {
        return String.format(
            "%s se inscreveu no canal %s!",
            event.user.name,
            event.channel.name
        )
    }

    private fun resubscription(event: SubscriptionEvent): String {
        return String.format(
            "%s continuou a inscrição no canal %s por %s meses!",
            event.user.name,
            event.channel.name,
            event.months
        )
    }

}
