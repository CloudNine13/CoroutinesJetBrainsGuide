import kotlinx.coroutines.*

val job = Job()
val job1 = Job()

fun main() {

    GlobalScope.launch {
        print("Hello")
        delay(1000L)
        injectFirst()
        delay(1000L) //No bloquea el hilo sino suspende la actividad de la coroutina.
    }

    CoroutineScope(Dispatchers.IO + job1).launch {
        delay(1020L)
        injectSecond()
    }

    Thread.sleep(5000) //Bloquea el hilo
}

private suspend fun injectFirst() {
    withContext(Dispatchers.IO + job) {
        print(", ")
    }
}

private fun injectSecond() {
        println("World!")
}