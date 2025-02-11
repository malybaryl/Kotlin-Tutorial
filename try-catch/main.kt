// Notatka: Obsługa wyjątków w Kotlinie

// Podstawowy try-catch
fun basicTryCatch() {
    try {
        val number = "abc".toInt() // Spowoduje wyjątek
        println(number)
    } catch (e: NumberFormatException) {
        println("Błąd konwersji: ${e.message}")
    }
}

// Try-catch z finally
fun tryCatchFinally() {
    try {
        val list = listOf(1, 2, 3)
        println(list[5]) // Indeks poza zakresem
    } catch (e: IndexOutOfBoundsException) {
        println("Błąd: ${e.message}")
    } finally {
        println("Blok finally zawsze się wykonuje")
    }
}

// Rzucanie wyjątków
fun throwException() {
    throw IllegalArgumentException("Nieprawidłowy argument!")
}

// Obsługa wielu wyjątków
fun multipleCatch() {
    try {
        val num = "123a".toInt()
    } catch (e: NumberFormatException) {
        println("Błąd formatu liczby: ${e.message}")
    } catch (e: Exception) {
        println("Inny błąd: ${e.message}")
    }
}

// Try-catch zwracający wartość
fun tryCatchWithReturn(): Int {
    return try {
        "100".toInt()
    } catch (e: NumberFormatException) {
        -1 // Zwracamy domyślną wartość w przypadku błędu
    }
}

// Przykład użycia
fun main() {
    basicTryCatch()
    tryCatchFinally()
    
    try {
        throwException()
    } catch (e: IllegalArgumentException) {
        println("Obsłużony wyjątek: ${e.message}")
    }
    
    multipleCatch()
    println("Wynik: ${tryCatchWithReturn()}")
}