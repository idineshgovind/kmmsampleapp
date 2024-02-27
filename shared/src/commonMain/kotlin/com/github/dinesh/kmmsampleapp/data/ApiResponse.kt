package com.github.dinesh.kmmsampleapp.data

class ApiResponse<T> (
    val isSuccess: Boolean,
    val statusCode: Int,
    val data: T?,
    val exception: Throwable?
)