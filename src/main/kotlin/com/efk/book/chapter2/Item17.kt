package com.efk.book.chapter2


fun call(before: () -> Unit = {}, after: () -> Unit = {}) {
    before()
    println("middle")
    after()
}

fun main() {
    call { println("call") }
    println("-----------")
    call({ println("call") })

    call(before = { print("call") })
    println("-----------")
    call(after = { println("call") })
}