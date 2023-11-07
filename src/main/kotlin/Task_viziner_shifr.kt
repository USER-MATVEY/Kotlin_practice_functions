fun main() {
    print("Введите текст, который хотите зашифровать: ")
    val plaintext = readln()
    print("Введите ключ шифрования: ")
    val keyword = readln()
    println("#############################################")

    // Создаем таблицу Виженера
    val table = Array(33) { CharArray(33) }
    for (i in 0..<33) {
        for (j in 0..<33) {
            table[i][j] = ((i + j) % 33 + 'А'.code).toChar()
        }
    }

    // Преобразуем ключевое слово в последовательность чисел
    val key = keyword.uppercase().map { it - 'А' }

    // Шифруем исходный текст
    val ciphertext: String = incripting(plaintext, key, table)

    //Дешифруем ранее зашифрованный текст
    val unciphertext: String = decripting(ciphertext, key, table)

    println("Исходный тектс: $plaintext")
    println("Ключевое слово: $keyword")
    println("Зашифрованный текст: $ciphertext")
    println("Расшифрованный текст: $unciphertext")
}

private fun incripting(plaintext: String, key: List<Int>, table: Array<CharArray>): String {
    var ciphertext = ""
    for (i in plaintext.indices) {
        if (!plaintext[i].isLetter()) {
            ciphertext += plaintext[i]
            continue
        }
        val pi = plaintext[i].uppercaseChar() - 'А'
        val kj = key[i % key.size]
        ciphertext += table[pi][kj]
    }
    return ciphertext
}

private fun decripting(ciphertext: String, key: List<Int>, table: Array<CharArray>): String {
    var unciphertext = ""
    for (i in ciphertext.indices) {
        if (!ciphertext[i].isLetter()) {
            unciphertext += ciphertext
            continue
        }
        val kj = key[i % key.size]
        unciphertext += table[0][table[kj].indexOf(ciphertext[i])]
    }
    return unciphertext
}