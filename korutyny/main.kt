import kotlinx.coroutines.*

// Przykład korutyny - GlobalScope
fun exampleCoroutine() {
    GlobalScope.launch {
        delay(1000L)
        println("Dwa")
    }
    println("Raz")
    Thread.sleep(2000L) // Blokuje wątek główny
}

// Blokowanie wątku za pomocą runBlocking
fun blockingExample() {
    GlobalScope.launch {
        delay(1000L)
        println("Dwa")
    }
    println("Raz")
    runBlocking {
        delay(2000L) // Blokuje wątek główny
    }
}

// Oczekiwanie na zakończenie korutyny
fun waitingCoroutine() = runBlocking {
    val job = GlobalScope.launch {
        delay(1000L)
        println("Dwa")
    }
    println("Raz")
    job.join() // Czekamy na zakończenie korutyny
}

// Zasięg korutyny
fun coroutineScopeExample() = runBlocking {
    launch {
        delay(1000L)
        println("Dwa")
    }
    println("Raz")
}

// Własny zasięg korutyny
fun customScope() = runBlocking {
    launch {
        delay(200L)
        println("Kor. z zasięgu runBlocking")
    }
    coroutineScope {
        launch {
            delay(500L)
            println("Kor. z własnego zasięgu")
        }
        delay(100L)
        println("Własny zasięg")
    }
    println("Zasięg runBlocking")
}

// Funkcja zawieszająca
suspend fun doWorld() {
    delay(1000L)
    println("Raz")
}

fun suspendFunctionExample() = runBlocking {
    launch { doWorld() }
    println("Dwa")
}

// Anulowanie korutyny
fun cancelCoroutine() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("kor: Liczę $i ...")
            delay(500L)
        }
    }
    delay(1300L)
    job.cancel()
    job.join()
}

// Anulowanie korutyny, gdy nie zawsze można
fun cancelWithCondition() = runBlocking {
    val job = launch {
        while (true) { }
    }
    delay(1300L)
    job.cancelAndJoin()
}

// Ograniczenie czasowe dla korutyny
fun timeoutExample() = runBlocking {
    withTimeout(1300L) {
        repeat(1000) { i ->
            println("Liczę $i ...")
            delay(500L)
        }
    }
}

// Asynchronizm korutyn
suspend fun f1(): Int {
    delay(1000L)
    println("f1")
    return 2
}

suspend fun f2(): Int {
    delay(500L)
    println("f2")
    return 3
}

fun asyncExample() = runBlocking {
    launch {
        val x = f1()
        val y = f2()
        println(x + y)

        val a = async { f1() }
        val b = async { f2() }
        println(a.await() + b.await())
    }
}
