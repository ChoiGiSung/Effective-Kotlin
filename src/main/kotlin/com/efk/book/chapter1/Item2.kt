package com.efk.book.chapter1

import java.awt.Color

class Item2(val name: String) {
}

// 변수는 선언과 동시에 초기화를 하는 것이 변경 지점을 찾기 좋다. 추적과 관리가 쉬워진다
//예제
var item: Item2 = Item2("name")
val items: List<Item2> = listOf(item)

fun itemSample() {
    //나쁜예
    for (i in items.indices) {
        item = items[i]
        println("$i is $item")
    }

    // 좋은예
    for ((i, item) in items.withIndex()) {
        println("$i is $item")
    }
}

// 여러 프로퍼티를 한번에 설정해야한다면 구조분해 선언을 사용하자
fun updateWeather(degrees: Int) {
    val (description, color) = when {
        degrees < 5 -> "cold" to Color.BLUE
        degrees < 23 -> "mild" to Color.YELLOW
        else -> "hot" to Color.RED
    }
}

//시퀀스를 사용하면 외부 변수 사용시 변수를 캡쳐하는데 필터링이 지연되는데 최종적인 외부 변수만 사용된다.
// 이를 막기위해(잠재적인 캡처문제) 변수를 스코프를 줄이자
val primes: Sequence<Int> = sequence {
    var numbers = generateSequence(2) { it + 1 }

    var prime: Int
    while (true) {
        prime = numbers.first()
        yield(prime)
        numbers = numbers.drop(1)
            .filter { it % prime != 0 }
    }
}
