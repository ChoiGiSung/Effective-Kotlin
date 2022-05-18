package com.efk.book.chapter2

class Item11 {

    fun ifOriginal(param: String?) {
        if (param != null && param.length > 3) {
            print(param.length)
        } else {
            print("실패")
        }
    }

    fun ifKotlin(param: String?) {
        param?.takeIf { it.length > 3 }
            ?.let { print(it.length) }
            ?: kotlin.run { println("실패") }
    }
}