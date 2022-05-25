package com.efk.book.chapter5

// 팩토리 함수의 장점은 이름을 붙일 수 있다는 것
// 생성자와는 다르게 원하는 타입을 return 할 수 있다는 것
// 매번 객체를 새로 만드는 것이 아닌 싱글톤 처럼 하나의 객체를 반환할 수 있다
// 팩ㅌ리 함수는 인라인으로 만들 수 있다

// 팩토리 함수 종류
//1. companion 객체 팩토리 함수 -> java에서의 static 팩토리 메소드 패턴
class Item33 {
    companion object {
        fun of(): Item33 = Item33()
    }
}
// from : 파라미터를 하나 받고 같은 타입을 return
// of : 파라미터를 여러개 받고 return
//

abstract class ItemFactory {
    abstract fun getIntent(): String

    fun start(){
        print("par")
    }
}

class Item{

    companion object: ItemFactory(){
        override fun getIntent(): String {
            TODO("Not yet implemented")
        }

    }

}
fun  Item.Companion.create() = Item()

fun main(){
    val item : String = Item.getIntent()

    //확장 팩토리 함수
   Item.create()
}