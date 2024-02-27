package com.github.dinesh.kmmsampleapp.data

sealed class State {
    object empty: State()
    object loading: State()
    class result(val data: List<Hits>): State()
    class error(val message: String): State()
}