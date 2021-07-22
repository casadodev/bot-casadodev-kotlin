package com.casadodev.features

import com.github.philippheuer.events4j.simple.SimpleEventHandler
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent

class WriteChannelChatToConsole(eventHandler: SimpleEventHandler) {
    init {
        eventHandler.onEvent(ChannelMessageEvent::class.java, this::onChannelMessage)
    }

    private fun onChannelMessage(event: ChannelMessageEvent) {
        System.out.printf(
            "Canal [%s] - [%s] - [%s]%n",
            event.channel.name,
            event.user.name,
            event.message
        )
    }

}
