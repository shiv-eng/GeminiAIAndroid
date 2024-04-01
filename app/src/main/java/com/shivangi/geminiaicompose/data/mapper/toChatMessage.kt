package com.shivangi.geminiaicompose.data.mapper

import com.shivangi.geminiaicompose.data.model.ChatMessageEntity
import com.shivangi.geminiaicompose.ui.model.ChatMessage
import java.util.Date

fun ChatMessageEntity.toChatMessage(): ChatMessage {
    return ChatMessage(
        isPending = isPending,
        text = text,
        participant = role,
        id = id,
        cId = cId,
        imageUris = imageUris
    )
}

fun ChatMessage.toChatMessageEntity(): ChatMessageEntity {
    return ChatMessageEntity(
        cId = cId,
        id = id,
        role = participant,
        text = text,
        time = Date(),
        isMine = false,
        isFavorite = false,
        isPending = isPending,
        imageUris = imageUris
    )
}