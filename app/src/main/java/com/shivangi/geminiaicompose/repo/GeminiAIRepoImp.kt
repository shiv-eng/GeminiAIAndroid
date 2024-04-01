package com.shivangi.geminiaicompose.repo

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.GenerationConfig
import com.google.ai.client.generativeai.type.SafetySetting
import com.google.ai.client.generativeai.type.generationConfig


class GeminiAIRepoImpl : GeminiAIRepo {
    override fun provideConfig(): GenerationConfig {
        return generationConfig {
            temperature = 0.7f
        }
    }

    override fun getGenerativeModel(
        modelName: String,
        config: GenerationConfig,
        safetySetting: List<SafetySetting>?,
    ): GenerativeModel {
        return GenerativeModel(
            modelName = modelName,
            apiKey = "YOUR API",
            generationConfig = config,
            safetySettings = safetySetting
        )
    }
}
