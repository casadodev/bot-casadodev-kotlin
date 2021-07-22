package com.casadodev.features

import com.github.philippheuer.events4j.simple.SimpleEventHandler
import com.github.twitch4j.chat.events.channel.DonationEvent

class ChannelNotificationOnDonation(eventHandler: SimpleEventHandler) {
    init {
        eventHandler.onEvent(DonationEvent::class.java, this::onDonation)
    }

    private fun onDonation(event: DonationEvent) {
        val message = String.format(
            "%s fez uma doação de %s!",
            event.user.name,
            event.amount
        )

        event.twitchChat.sendMessage(event.channel.name, message)
    }

}
