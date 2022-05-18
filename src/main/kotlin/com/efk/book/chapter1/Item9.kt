package com.efk.book.chapter1

import java.io.BufferedReader
import java.io.FileReader

class Item9 {
}

fun reader(path: String): Int {
    BufferedReader(FileReader(path)).use { reader ->
        return reader.lineSequence().sumOf { it.length }
    }
}