package com.example.composeapp.base.extension

inline fun <reified T> T?.isNull(
    crossinline doOnIsNull: () -> Unit,
    crossinline doOnIsNotNull: (T) -> Unit
) {
    this ?: doOnIsNull.invoke()
    this?.let(doOnIsNotNull)
}

suspend inline fun <reified T> T?.isNullOnFlow(
    crossinline doOnIsNull: suspend () -> Unit,
    crossinline doOnIsNotNull: suspend (T) -> Unit
) {
    this ?: doOnIsNull.invoke()
    this?.let {
        doOnIsNotNull.invoke(it)
    }
}