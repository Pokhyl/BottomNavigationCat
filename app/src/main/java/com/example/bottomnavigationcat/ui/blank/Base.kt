package com.example.bottomnavigationcat.ui.blank

interface Base {
    fun someFun()
}
 
class BaseImpl() : Base {
    override fun someFun() { }
}
 
class Derived(someBase: Base) : Base by someBase
interface Messenger{
    fun send(message: String)
}
open class InstantMessenger(val programName: String) : Messenger{

    override fun send(message: String){
        println("Message `$message` has been sent")
    }
}
class SmartPhone(val name: String, m: Messenger): Messenger by m
fun main() {
    val telegram = InstantMessenger("Telegram")
    val pixel = SmartPhone("Pixel 5", telegram)
    pixel.send("Hello Kotlin")
    pixel.send("Learn Kotlin on Metanit.com")
}