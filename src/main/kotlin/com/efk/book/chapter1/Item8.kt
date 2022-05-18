package com.efk.book.chapter1

import kotlin.properties.Delegates

// null은 여러 방법으로 처리가 가능한데 throw나 ?. ?: 등이나 함수 리팩토링이 있을 수 있다.

fun smartCast() {
    var name: String? = ""

    //not smart
    name?.toString()

    //smart
    if (name != null) {
        print(name.length)
    }
}

fun elvis(){
    // elvis에는 return이나 throw가 들어갈 수 있다.
}

// 위는 방어적 코딩이 였다면 이전 아이템5에서본 check나 requre는 공격적 코딩이다. 사용자에게 직접 알려주는 것이다.
// 공격적 코딩은 특정 값이 예상을 벗어나면 안되는 경우에 사용할 수 있다 (!!,requireNotNull, check 등)


//Delegates.notNull()은 프리미티브 타입의 lateinit이라고 보면된다
var id : Int by Delegates.notNull()