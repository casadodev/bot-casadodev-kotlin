package com.casadodev.features

import com.github.philippheuer.events4j.simple.SimpleEventHandler
import com.github.twitch4j.chat.events.channel.FollowEvent

class ChannelNotificationOnFollow(eventHandler: SimpleEventHandler) {
    init {
        eventHandler.onEvent(FollowEvent::class.java, this::onFollow)
    }

    private fun onFollow(event: FollowEvent) {
        val message = String.format(
            "%s agora está seguindo o canal %s!",
            event.user.name,
            event.channel.name
        )
        event.twitchChat.sendMessage(event.channel.name, message)
    }

}
