import kotlinx.coroutines.*

val job1 = Job()

fun main() =  runBlocking{



    inject2()
    test()
    job1.join() // wait until previous (child) coroutine completes
    inject3()
}

private fun inject() {
    println("World!")

}

private suspend fun test() {
    CoroutineScope(job1).launch {
    }
        // launch a new coroutine and keep a reference to its Job
        delay(2000)
        inject()
        delay(20000)
    }


private fun inject2(){
    print("Hello, ")
}

private fun inject3() {
    println("I love Kotlin coroutines!")
}