package com.efk.book.chapter1

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass

open class Car
class Fiat126P : Car()

interface CarFactory {
    fun produce(): Car
}

// 명시시 Car로 바꿀 수 없다 -> 타입을 명시하자
//val DEFAULT_CAR = Fiat126P()
val DEFAULT_CAR : Car = Fiat126P()
