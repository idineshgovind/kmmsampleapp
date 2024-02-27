package com.github.dinesh.kmmsampleapp.di

import com.github.dinesh.kmmsampleapp.network.NetworkClient
import com.github.dinesh.kmmsampleapp.repository.PexelImagesUseCase
import com.github.dinesh.kmmsampleapp.repository.PixadayImagesUseCase
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val KodeinInjector = DI {
    val client = lazy {
        NetworkClient()
    }
    bindSingleton { PexelImagesUseCase(client) }
    bindSingleton { PixadayImagesUseCase(client) }
}