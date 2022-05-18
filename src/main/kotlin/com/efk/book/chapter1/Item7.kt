package com.efk.book.chapter1

// null 또는 실패를 나타내는 Failure라는 이름이 붙은 class를 리턴한다.
// 예상되는 오류는 null이나 Faulure를 사용하자. 예외는 비용이 많이 든다.
// try catch 블록 내부에 코드를 배치하면 컴파일러가 할 수 있는 최적화가 제한됨
// null과 result는 명시적으로 처리해야함
// list의 get과 getOrNull을 생각하자.


sealed class Result<out T>
class Failure(val throwable: Throwable) : Result<Nothing>()
class Success() : Result<Nothing>()
class JsonException : Exception()

val isJson = true
inline fun String.returnNull(): String? {
    if (isJson) {
        return null
    }
    return "result"
}

inline fun String.returnException(): String? {
    if (isJson) {
        throw JsonException()
    }
    return "result"
}

inline fun <reified T> String.returnFail(): Result<T> {
    if (isJson) {
        return Failure(JsonException())
    }
    return Success()
}

fun main() {
    //밑의 2개는 try문 없이 동작
    "result".returnNull() ?: "notNull"
    when("result".returnFail<String>()){
        is Success -> "success"
        is Failure -> "fail"
    }

    try {
        "result".returnException()
    }catch (e : Exception){
        println("gg")
    }

}