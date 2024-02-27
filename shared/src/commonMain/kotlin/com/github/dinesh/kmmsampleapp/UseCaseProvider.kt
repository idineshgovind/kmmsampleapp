package com.github.dinesh.kmmsampleapp

import com.github.dinesh.kmmsampleapp.di.KodeinInjector
import com.github.dinesh.kmmsampleapp.repository.PexelImagesUseCase
import com.github.dinesh.kmmsampleapp.repository.PixadayImagesUseCase
import org.kodein.di.instance
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object UseCaseProvider {
    val pexelImagesUseCase by KodeinInjector.instance<PexelImagesUseCase>()
    val pixabayImagesUseCase by KodeinInjector.instance<PixadayImagesUseCase>()
}