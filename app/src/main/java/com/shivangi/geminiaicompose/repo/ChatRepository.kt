package com.shivangi.geminiaicompose.repo

import com.shivangi.geminiaicompose.data.model.ChatMessageEntity
import com.shivangi.geminiaicompose.data.model.GroupEntity
import com.shivangi.geminiaicompose.ui.model.ChatMessage
import kotlinx.coroutines.flow.Flow

interface ChatRepository {

    fun getAllGroups(): Flow<List<GroupEntity>>

    suspend fun insertChatsInGroup(groupEntity: GroupEntity)

    suspend fun updateChatsInGroup(groupEntity: GroupEntity)

    suspend fun getById(groupId: Int): GroupEntity

    fun getAllChatMessages(id: String): Flow<List<ChatMessage>>

    suspend fun insertSingleMessage(chatMessageEntity: ChatMessageEntity)

    suspend fun deleteChats(groupId: String)
}