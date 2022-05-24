package com.efk.book.chapter2

class Node(val name: String) {
    fun makeChild(childName: String) =
        create("$name.$childName").also {
            print("${it?.name}")
        }
    //parent.child

    fun makeChildNotThis(childName: String) =
        create("$name.$childName").also {
            print("$name")
        }
    //parent


    fun create(name: String): Node? = Node(name)
}

fun main() {
    val node = Node("parent")
    node.makeChild("child")

}