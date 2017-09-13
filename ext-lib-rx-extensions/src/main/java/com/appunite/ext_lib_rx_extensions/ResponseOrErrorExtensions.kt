package com.appunite.ext_lib_rx_extensions

import com.appunite.rx.ResponseOrError
import rx.Observable


fun <T> Observable<ResponseOrError<T>>.onlySuccess(): Observable<T> {
    return this.compose(ResponseOrError.onlySuccess())
}

fun <T> Observable<ResponseOrError<T>>.onlyError(): Observable<Throwable> {
    return this.compose(ResponseOrError.onlyError())
}

fun <T> Observable<T>.toResponseOrError(): Observable<ResponseOrError<T>> {
    return this.compose(ResponseOrError.toResponseOrErrorObservable())
}

fun <T> Observable<ResponseOrError<T>>.onErrorCall(func: (t: Throwable) -> Unit?): Observable<ResponseOrError<T>> {
    return this.doOnNext { responseOrError -> if (responseOrError.isError) func(responseOrError.error()) }
}

fun <T> Observable<ResponseOrError<T>>.onSuccessCall(func: (data: T) -> Unit?): Observable<ResponseOrError<T>> {
    return this.doOnNext { responseOrError -> if (responseOrError.isData) func(responseOrError.data()) }
}

fun <T, R> Observable<ResponseOrError<T>>.mapResponse(func: (T) -> R): Observable<ResponseOrError<R>> {
    return this.compose(ResponseOrError.map(func))
}

fun <T, R> Observable<ResponseOrError<T>>.flatMapResponse(func: (T) -> Observable<ResponseOrError<R>>): Observable<ResponseOrError<R>> {
    return this.compose(ResponseOrError.flatMap(func))
}

fun <T, R> Observable<ResponseOrError<T>>.switchMapResponse(func: (T) -> Observable<ResponseOrError<R>>): Observable<ResponseOrError<R>> {
    return this.compose(ResponseOrError.switchMap(func))
}

