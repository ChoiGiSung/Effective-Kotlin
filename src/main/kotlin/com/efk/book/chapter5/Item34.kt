package com.efk.book.chapter5

class Item34(
    val name: String = "철수",
    val addr: String = "서울"
) {
}

fun main(){

    //코틀린은 여러 생성자를 만들지 않아도 된다
    Item34(
        addr = "영국"
    )

    //코틀린은 빌더 패턴을 대신할 수 있다.
    Item34(
        name = "메시",
        addr = "파리"
    )
}