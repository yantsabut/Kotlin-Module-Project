import java.util.Scanner

val archive: MutableMap<String, MutableMap<String, String>> = mutableMapOf()
val scanner: Scanner = Scanner(System.`in`)
var archiveName: String? = null
fun main() {
    println(
        "Привет!" +
                "\nДобро пожаловать в приложение 'Заметки'!"
    )
    menuArchive("архив", "Выход", archive.keys, ::createArchive, ::openArchive)
    println("Выход из приложения 'Заметки'!")

}

fun menuArchive(
    name: String, exit: String, menuList: Iterable<String>, toCreationMenu: () -> Unit,
    toNextMenu: (input: Int) -> Unit
) {
    while (true) {
        println("Меню $name: \n0. Создать $name")
        var counter = 1
        menuList.forEach { println("${counter++}. $it") }
        println("$counter. $exit")
        while (scanner.hasNext() and !scanner.hasNextInt()) {
            println("Ошибка ввода  ${scanner.next()}.Повторите попытку.")
        }
        when (val input = scanner.nextInt()) {
            0 -> toCreationMenu()
            in 0 until counter -> toNextMenu(input)
            counter -> {
                break
            }
            else -> println("Ошибка ввода, повторите попытку.")
        }
    }
}

fun createArchive() {
    println("Введите название архива:")
    scanner.nextLine()
    val archiveName = scanner.nextLine()
    archive[archiveName] = mutableMapOf()
    println("Создан архив: '$archiveName'")
}

fun openArchive(input: Int) {
    archiveName = archive.keys.elementAt(input - 1)
    println("Это ваш уже созданный архив: $archiveName\n")
    menuArchive("заметки", "Назад", archive[archiveName]!!.keys, ::createNote, ::showNote)
}

