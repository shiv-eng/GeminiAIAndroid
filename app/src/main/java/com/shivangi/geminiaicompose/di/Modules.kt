package com.shivangi.geminiaicompose.di

import com.shivangi.geminiaicompose.data.db.ChatDatabase
import com.shivangi.geminiaicompose.ui.viewmodel.ChatViewModel
import com.shivangi.geminiaicompose.ui.viewmodel.GroupViewModel
import com.shivangi.geminiaicompose.repo.ChatRepository
import com.shivangi.geminiaicompose.repo.ChatRepositoryImpl
import com.shivangi.geminiaicompose.repo.GeminiAIRepo
import com.shivangi.geminiaicompose.repo.GeminiAIRepoImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::GeminiAIRepoImpl) { bind<GeminiAIRepo>() }
}

val viewModelModule = module {
    viewModelOf(::ChatViewModel)
    viewModelOf(::GroupViewModel)
}
val databaseModule = module {
    single { ChatDatabase.getInstance(androidApplication()) }
    singleOf(::ChatRepositoryImpl){ bind<ChatRepository>()}
}