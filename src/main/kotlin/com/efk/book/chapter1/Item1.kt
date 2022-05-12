package com.efk.book.chapter1

val name: String? = "M"
val surname: String = "B"

val fullName: String?
    get() = name?.let { "$it $surname" }
val fullName2: String? = name?.let { "$it $surname" }

fun main() {
    if (fullName != null) {
//        println(fullName.length)
        //스마트 캐스트를 할 수 없어 오류가 난다. -> get을 오버라이딩 해서이다.
    }

    if (fullName2 != null) {
        println(fullName2.length)
    }

    val mutableList = listOf(1, 2).toMutableList()
}

//우리가 만드는 ummutable 객체도 값변경시 새로운 객체를 반환해야한다 -> data class는 copy를 제공한다
class User(
    val name: String,
    val surname: String,
) {
    fun withSurname(surname: String) = User(name, surname)
}

// 변경 가능한 리스트를 만들고자 할 때 두가지 방법이 있다
val list1: MutableList<Int> = mutableListOf() // 변경 가능한 리스트를 사용한다
var list2: List<Int> = listOf() // 변경 가능한 프로퍼티를 사용한다

fun listSample() {
    list1 += 1 // list1.plusAssuign(1)로 변환 -> 내부 변경 (멀티 스레드 불안정)
    list2 += 1 // list2.plus(1) -> 프로퍼티 자체가 변경 (멀티 스레드 안정)
}
// mutable 프로퍼티에 읽기 전용 컬렉션을 넣어 사용하자. 쉽게 변경 가능하고 또는 set을 막을 수도 있다


// mutable을 외부에 노출하는 것은 위험할 수 있다. 외부에서 get후 add하면 값이 추가됨
// 방어적 복제를 하던가 읽기 전용으로 업캐스팅하자
data class FaceBookUser(val name: String) {
    private val storedUser: MutableList<Int> = mutableListOf()

//    fun get(): MutableList<Int>{
//        return storedUser.copy()
//    }

    fun allLoad(): List<Int> {
        return storedUser
    }
}
