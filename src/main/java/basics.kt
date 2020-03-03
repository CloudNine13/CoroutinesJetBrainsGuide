import kotlinx.coroutines.*

val job = Job()
val job1 = Job()

fun main() =  runBlocking{

    GlobalScope.launch {
        delay(2000)
        inject()
    }
    inject2()
    delay(2000)
}

private fun inject() {
        println("World!")
}

private fun inject2(){
    println("Hello,")
}