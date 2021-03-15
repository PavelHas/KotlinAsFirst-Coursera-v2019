@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson6.task1

//import lesson4.task1.digitNumber
import java.lang.IllegalArgumentException

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}
/**
 * Пример: консольный ввод
 */
fun main() {

    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        } else {
            println("Прошло секунд с начала суток: $seconds")
        }
    } else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }

}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку.
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30.02.2009) считается неверными
 * входными данными.
 */
fun dateStrToDigit(str: String): String //= TODO()
{
    val parts = str.split(" ")
    if (parts.size != 3) return ""
    val myday: Int = parts[0].toIntOrNull() ?: return ""
    var mymonth: Int = 0
    when (parts[1]) {
        "января" -> mymonth = 1
        "февраля" -> mymonth = 2
        "марта" -> mymonth = 3
        "апреля" -> mymonth = 4
        "мая" -> mymonth = 5
        "июня" -> mymonth = 6
        "июля" -> mymonth = 7
        "августа" -> mymonth = 8
        "сентября" -> mymonth = 9
        "октября" -> mymonth = 10
        "ноября" -> mymonth = 11
        "декабря" -> mymonth = 12
        else -> return ""
    }
    val myyear: Int = parts[2].toInt()
    if ((((myyear % 4 == 0) && (myyear % 100 != 0)) || myyear % 400 == 0) && mymonth == 2 && myday > 29) return ""
    if (!(((myyear % 4 == 0) && (myyear % 100 != 0)) || myyear % 400 == 0) && mymonth == 2 && myday > 28) return ""
    if (mymonth > 12) return ""
    if ((mymonth == 4 || mymonth == 6 || mymonth == 9 || mymonth == 11) && myday > 30) return ""
    if ((mymonth == 1 || mymonth == 3 || mymonth == 5 || mymonth == 7 || mymonth == 8 || mymonth == 10 || mymonth == 12) && myday > 31) return ""
    val result: String = twoDigitStr(myday) + "." + twoDigitStr(mymonth) + "." + myyear.toString()
    return result
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30 февраля 2009) считается неверными
 * входными данными.
 */
fun dateDigitToStr(digital: String): String //= TODO()
{
    val parts = digital.split(".")
    if (parts.size != 3) return ""
    val myday: Int = parts[0].toIntOrNull() ?: return ""
    var mymonth: String = ""
    when (parts[1].toInt()) {
        1 -> mymonth = "января"
        2 -> mymonth = "февраля"
        3 -> mymonth = "марта"
        4 -> mymonth = "апреля"
        5 -> mymonth = "мая"
        6 -> mymonth = "июня"
        7 -> mymonth = "июля"
        8 -> mymonth = "августа"
        9 -> mymonth = "сентября"
        10 -> mymonth = "октября"
        11 -> mymonth = "ноября"
        12 -> mymonth = "декабря"
        else -> return ""
    }
    val myyear: Int = parts[2].toInt()
    if ((((myyear % 4 == 0) && (myyear % 100 != 0)) || myyear % 400 == 0) && parts[1].toInt() == 2 && myday > 29) return ""
    if (!(((myyear % 4 == 0) && (myyear % 100 != 0)) || myyear % 400 == 0) && parts[1].toInt() == 2 && myday > 28) return ""
    if (parts[1].toInt() > 12) return ""
    if ((parts[1].toInt() == 4 || parts[1].toInt() == 6 || parts[1].toInt() == 9 || parts[1].toInt() == 11) && myday > 30) return ""
    if ((parts[1].toInt() == 1 || parts[1].toInt() == 3 || parts[1].toInt() == 5 || parts[1].toInt() == 7 || parts[1].toInt() == 8 || parts[1].toInt() == 10 || parts[1].toInt() == 12) && myday > 31) return ""
    val result: String = myday.toString() + " " + mymonth + " " + myyear.toString()
    return result
}

/**
 * Средняя
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -89 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку.
 *
 * PS: Дополнительные примеры работы функции можно посмотреть в соответствующих тестах.
 */
fun flattenPhoneNumber(phone: String): String //= TODO()
{
    var result: String = ""
    if (phone[0] == '+') result += "+"
    for (i in phone.indices) {
        if (phone[i] == '(' && phone[i + 1] == ')') return ""
        if (phone[i].isDigit()) result += phone[i]
        else
            if (phone[i] == ' ' || phone[i] == '+' || phone[i] == '-' || phone[i] == '(' || phone[i] == ')') continue else return ""
    }
    return result
}

/**
 * Средняя
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int //= TODO()
{
    val volumesOfJumps: MutableList<Int> = mutableListOf()
    val jumpsParts = jumps.split(" ")
    for (jumpsPart in jumpsParts) {
        if (jumpsPart == "-" || jumpsPart == "%") continue
        if (jumpsPart.toIntOrNull() == null) return -1
        volumesOfJumps.add(jumpsPart.toInt())
    }
    if (volumesOfJumps.size == 0) return -1
    volumesOfJumps.sort()
    return volumesOfJumps[volumesOfJumps.size - 1]
}

/**
 * Сложная
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки, а также в случае отсутствия удачных попыток,
 * вернуть -1.
 */
fun bestHighJump(jumps: String): Int //= TODO()
{
    val volumesOfJumps: MutableList<Int> = mutableListOf()
    var digit: String = ""
    if (!jumps[0].isDigit()) return -1
    for (i in jumps.indices) {
        if (jumps[i] != ' ' && jumps[i] != '-' && jumps[i] != '+' && jumps[i] != '%' && !jumps[i].isDigit()) return -1
        if (jumps[i].isDigit()) digit += jumps[i]
        if (digit.isNotEmpty() && (jumps.length - 1 > i))
            if (jumps[i + 1] == ' ') {
                if (jumps.length - 2 > i) if (jumps[i + 2] == '+') volumesOfJumps.add(digit.toInt())
                digit = ""
            } else if (!jumps[i + 1].isDigit()) return -1
    }
    if (volumesOfJumps.size == 0) return -1
    volumesOfJumps.sort()
    return volumesOfJumps[volumesOfJumps.size - 1]
}

/**
 * Сложная
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int //= TODO()
{
    var result: Int
    val volumesOfexpression: MutableList<String> = mutableListOf()
    val expressionParts = expression.split(" ")
    for (expressionPart in expressionParts) {
        if (allDigit(expressionPart)) volumesOfexpression.add(expressionPart)
        else {
            if (expressionParts.indexOf(expressionPart) % 2 != 0 && (expressionPart == "+" || expressionPart == "-")) {
                if (expressionPart == "+") volumesOfexpression.add("+")
                if (expressionPart == "-") volumesOfexpression.add("-")
            } else throw IllegalArgumentException("Incorrect input data")
        }
    }
    result = volumesOfexpression[0].toInt()
    for (i in 0..volumesOfexpression.size - 2 step 2) {
        if (volumesOfexpression[i + 1] == "+") result = result + volumesOfexpression[i + 2].toInt()
        if (volumesOfexpression[i + 1] == "-") result = result - volumesOfexpression[i + 2].toInt()
    }
    return result
}

fun allDigit(volumeString: String): Boolean {
    for (volume in volumeString) if (!volume.isDigit()) return false
    if (volumeString == "") return false
    return true
}

/**
 * Сложная
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int //= TODO()
{
    var volume1: String = ""
    var volume2: String = ""
    for (i in 0..str.length - 1) {
        if (str[i] != ' ') volume1 += str[i]
        else {
            if (volume1 == "" && volume2 == "") {
                volume2 = volume1
                volume1 = ""
            }
            if (volume1.equals(volume2, ignoreCase = true)) return i - (volume1.length * 2 + 1)
            else {
                volume2 = volume1
                volume1 = ""
            }
        }
        if (i == str.length - 1) if (volume1.equals(volume2, ignoreCase = true)) return i - (volume1.length * 2)
    }
    return -1
}

/**
 * Сложная
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть больше либо равны нуля.
 */
fun mostExpensive(description: String): String //= TODO()
{
    if (description == "") return ""
    val descriptionList = mutableListOf<Pair<String, Double>>()
    val descriptionListParts = description.split("; ")
    if (descriptionListParts.isEmpty()) return ""
    for (descriptionListPart in descriptionListParts) {
        val descriptionListPartIn = descriptionListPart.split(" ")
        if (descriptionListPartIn.size != 2) return ""
        if (descriptionListPartIn[1].toDoubleOrNull() == null) return ""
        else
            if (descriptionListPartIn[1].toDouble() < 0) return ""
            else {
                descriptionList.add(descriptionListPartIn[0] to descriptionListPartIn[1].toDouble())
            }
    }
    descriptionList.sortBy { it.second }
    return descriptionList[descriptionList.size - 1].first
}

/**
 * Сложная
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int //= TODO()
{
    var result: Int = 0
    val tablica = mapOf(
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000
    )
    var i: Int = 0
    while (i < roman.length) {
        if (roman[i] != 'I' && roman[i] != 'V' && roman[i] != 'X' && roman[i] != 'L' && roman[i] != 'C' && roman[i] != 'D' && roman[i] != 'M') return -1
        if (i == roman.length - 1) {
            result += tablica[roman[i].toString()]!!
            break
        }
        val xl: Int = tablica[roman[i].toString()]!!
        if (roman[i + 1] != 'I' && roman[i + 1] != 'V' && roman[i + 1] != 'X' && roman[i + 1] != 'L' && roman[i + 1] != 'C' && roman[i + 1] != 'D' && roman[i + 1] != 'M') return -1
        val xr: Int = tablica[roman[i + 1].toString()]!!
        if (xl >= xr) {
            result += xl
            i++
            continue
        }
        if (xl < xr) {
            result += xr - xl
            i += 2
            continue
        }
    }
    return result
}

/**
 * Очень сложная
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> //= TODO()
{
    var x11: Int = 0
    for (i in 0 until commands.length) {
        if (commands[i] != '+' && commands[i] != '-' && commands[i] != '<' && commands[i] != '>' && commands[i] != '[' && commands[i] != ']' && commands[i] != ' ') throw IllegalArgumentException("Incorrect input data")
        if (commands[i] == '[') x11 += 1
        if (commands[i] == ']') x11 -= 1
    }
    if (x11 != 0) throw IllegalArgumentException("Incorrect input data")
    val boxList: MutableList<Int> = mutableListOf()
    for (i in 0 until cells) boxList.add(i, 0)
    var countOfBox: Int = cells / 2
    var countOfCommands: Int = 0
    var countOfCommandsLimit: Int = 0
    while (countOfCommands < commands.length && countOfCommandsLimit < limit) {
        if (countOfCommandsLimit >= limit) throw IllegalArgumentException("Exiting the array boundary")
        if (countOfCommands > commands.length - 1 || countOfCommands < 0) throw IllegalArgumentException("Exiting the array boundary")
        if (countOfBox > boxList.size - 1 || countOfBox < 0) throw IllegalStateException("Exiting the array boundary")
        if (commands[countOfCommands] == '<') {
            countOfBox -= 1
            countOfCommands += 1
            countOfCommandsLimit += 1
            continue
        }
        if (commands[countOfCommands] == '>') {
            countOfBox += 1
            countOfCommands += 1
            countOfCommandsLimit += 1
            continue
        }
        if (commands[countOfCommands] == ' ') {
            countOfCommands += 1
            countOfCommandsLimit += 1
            continue
        }
        if (commands[countOfCommands] == '+') {
            boxList[countOfBox] = boxList[countOfBox] + 1
            countOfCommands += 1
            countOfCommandsLimit += 1
            continue
        }
        if (commands[countOfCommands] == '-') {
            boxList[countOfBox] = boxList[countOfBox] - 1
            countOfCommands += 1
            countOfCommandsLimit += 1
            continue
        }
        if (commands[countOfCommands] == '[') {
            if (boxList[countOfBox] == 0) {
                var x1: Int = 0
                while (commands[countOfCommands] != ']' || x1 == 0) {
                    countOfCommands += 1
                    if (commands[countOfCommands] == '[') x1 += 1
                    if (commands[countOfCommands] == ']') x1 -= 1
                }
            }
            countOfCommands += 1
            countOfCommandsLimit += 1
            continue
        }
        if (commands[countOfCommands] == ']') {
            if (boxList[countOfBox] != 0) {
                var x2: Int = 0
                while (commands[countOfCommands] != '[' || x2 == 0) {
                    countOfCommands -= 1
                    if (commands[countOfCommands] == ']') x2 += 1
                    if (commands[countOfCommands] == '[') x2 -= 1
                }
            }
            countOfCommands += 1
            countOfCommandsLimit += 1
            continue
        }
    }
    return boxList
}
