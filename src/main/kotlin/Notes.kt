fun createNote() {
    scanner.nextLine()
    println("Введите название новой заметки:")
    val notesName = scanner.nextLine()
    println("Введите текст новой заметки:")
    val notesText = scanner.nextLine()
    archive[archiveName]!![notesName] = notesText
    println("Создана заметка: $notesName\n")
}

fun showNote(input: Int) {
    while (true) {
        val notesText = archive[archiveName]!![archive[archiveName]!!.keys.elementAt(input - 1)]
        println(
            "Текст заметки:\n$notesText" +
                    " \nВведите любой символ для возврата"
        )
        scanner.next()
        break
    }
}