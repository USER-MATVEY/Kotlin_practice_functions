import java.lang.NumberFormatException

fun main() {
    println("Играем в камень-ножницы-бумага (ввод 0 - конец)")
    while (true) {
        println("Ваш выбор: 1-камень, 2-ножницы, 3-бумага: ")
        try {
            val players_input = readln().toInt()
            if (players_input == 0) return
            val computer_input = (1..3).random()
            println("выбор компьютера: $computer_input")
            game_result(players_input, computer_input)
        }
        catch (e: NumberFormatException) {
            println("Введено не чсило!!")
            continue
        }
    }
}

private fun game_result(players_input: Int, computer_input: Int) {
    when {
        (players_input == computer_input) -> println("Ничья!")
        (players_input == 1 && computer_input == 2) -> println("Вы выйграли!")
        (players_input == 1 && computer_input == 3) -> println("Выйграл компьютер!")
        (players_input == 2 && computer_input == 1) -> println("Выйграл компьютер!")
        (players_input == 2 && computer_input == 3) -> println("Вы выйграли!")
        (players_input == 3 && computer_input == 1) -> println("Вы выйграли!")
        (players_input == 3 && computer_input == 2) -> println("Выйграл компьюер!")
        (players_input !in (1..3)) -> println("НЕВЕРНЫЙ ВВОД!!")
    }
}