import kotlinx.coroutines.*

val job1 = Job()

fun main() =  runBlocking{

    val job = GlobalScope.launch { // launch a new coroutine and keep a reference to its Job
        delay(2000)
        inject()
        delay(2000)
    }

    inject2()
    job.join() // wait until previous (child) coroutine completes
    inject3()
}

private fun inject() {
        println("World!")
}

private fun inject2(){
    print("Hello, ")
}

private fun inject3() {
    println("I love Kotlin coroutines!")
}