import kotlinx.coroutines.*

val job1 = Job()

fun main() =  runBlocking{

    val job = GlobalScope.launch {
        delay(2000)
        inject()
        delay(2000)
    }

    inject2()
    delay(2000)
    job.join()
}

private fun inject() {
        println("World!")
}

private fun inject2(){
    println("Hello,")
}