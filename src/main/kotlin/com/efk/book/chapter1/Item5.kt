package com.efk.book.chapter1

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import kotlin.math.log
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass

//- require 블록 : 아규먼트를 제한할 수 있다 -> IllegalArgumentException
//- check 블록 : 상태와 관련된 동작을 제한할 수 있다 -> IllegalStateException
//- assert 블록 : test에만 돌아감. 어떤 것이 true인지 확인할 수 있다
//- return 또는 throw와 할께 활용하는 엘비스 연산자

//Stack<T> 의 일부
val size = 1
val isOpen = true

fun <T> pop(num: Int = 1) {
    require(1 < size) {
        "더이상 삭제 불가능"
    }

    check(isOpen) {
        "닫힌 스택에서 삭제 불가능"
    }

    assert(1 == num)
}

//코드가 자체적으로 검사되어 단위 테스트를 줄일 수 있다
// 스마트 캐스트를 활용할 수 있다

fun sendEmail(email: String?) {
    requireNotNull(email)
}

// nullability를 목저으로 throw나 return은 오른쪽에 둘 수 있다

fun sendEmail(text: String?, name: String) {
    val email: String = text ?: return
    val run: String = text ?: run {
        println("로그 찍기 가능")
        return
    }
}
