package com.github.dinesh.kmmsampleapp

actual fun runBlocking(block: suspend () -> Unit) = kotlinx.coroutines.runBlocking { block() }