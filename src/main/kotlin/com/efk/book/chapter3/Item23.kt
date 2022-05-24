package com.efk.book.chapter3

class Item23(val name: String) {

    fun sample(name: String) {
        println(name)
    }
}

fun main(){
    val item : Item23 = Item23("ss")


    item.sample("22")
}

