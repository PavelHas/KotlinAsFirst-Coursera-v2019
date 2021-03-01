@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.quadraticRootProduct
import java.lang.Math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double //= TODO()
{
    var result: Double = 0.0
    for (i in 0 until v.size) result += v[i] * v[i]
    result = sqrt(result)
    return result
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double //= TODO()
{
    var result: Double = 0.0
    if (list.size == 0) return 0.0
    for (i in 0 until list.size) result += list[i]
    result /= list.size
    return result
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> //= TODO()
{
    if (list.size == 0) return list
    list.toList()
    var x1: Double = mean(list)
    list.toMutableList()
    for (i in 0 until list.size) list[i] -= x1
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int //= TODO()
{
    var result: Int = 0
    for (i in 0 until a.size) result += a[i] * b[i]
    return result
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int //= TODO()
{
    var result: Int = 0
    if (p.size == 0) return result else result = p[0]
    for (i in 1 until p.size) result = result + (p[i] * pow(x.toDouble(), i.toDouble()).toInt())
    return result
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> //= TODO()
{
    if (list.size == 0) return list
    var x1: Int = list[0]
    for (i in 1 until list.size) {
        x1 += list[i]
        list[i] = x1
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> //= TODO()
{
    var list1: MutableList<Int> = mutableListOf()
    var x2: Int = n
    for (i in 1..n) {
        var x1: Int = 2
        while (x2 % x1 != 0) {
            x1++
        }
        list1.add(x1)
        x2 /= x1
        x1 = 1
        for (ii in 0 until list1.size) x1 *= list1[ii]
        if (x1 == n) {
            list1.sort()
            return list1.toList()
        }
    }
    list1.sort()
    return list1.toList()
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String //= TODO()
{
    var list1: MutableList<Int> = mutableListOf()
    var x2: Int = n
    for (i in 1..n) {
        var x1: Int = 2
        while (x2 % x1 != 0) {
            x1++
        }
        list1.add(x1)
        x2 /= x1
        x1 = 1
        for (ii in 0 until list1.size) x1 *= list1[ii]
        if (x1 == n) {
            list1.sort()
            return list1.joinToString(separator = "*")
        }
    }
    list1.sort()
    return list1.joinToString(separator = "*")
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> //= TODO()
{
    var list1: MutableList<Int> = mutableListOf()
    var x1: Int = n
    while (x1 / base >= 0) {
        list1.add(x1 % base)
        x1 /= base
        if (x1 == 0) break
    }
    list1.reverse()
    return list1.toList()
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String //= TODO()
{
    var list1: MutableList<String> = mutableListOf()
    var x1: Int = n
    var x2: Int
    var x22: String = ""
    while (x1 / base >= 0) {
        x2 = x1 % base
        x22 = x2.toString()
        when (x22) {
            "10" -> x22 = "a"
            "11" -> x22 = "b"
            "12" -> x22 = "c"
            "13" -> x22 = "d"
            "14" -> x22 = "e"
            "15" -> x22 = "f"
            "16" -> x22 = "g"
            "17" -> x22 = "h"
            "18" -> x22 = "i"
            "19" -> x22 = "j"
            "20" -> x22 = "k"
            "21" -> x22 = "l"
            "22" -> x22 = "m"
            "23" -> x22 = "n"
            "24" -> x22 = "o"
            "25" -> x22 = "p"
            "26" -> x22 = "q"
            "27" -> x22 = "r"
            "28" -> x22 = "s"
            "29" -> x22 = "t"
            "30" -> x22 = "u"
            "31" -> x22 = "v"
            "32" -> x22 = "w"
            "33" -> x22 = "x"
            "34" -> x22 = "y"
            "35" -> x22 = "z"
            //"36" -> x22 = "f"
        }
        list1.add(x22)
        x1 /= base
        if (x1 == 0) break
    }
    list1.reverse()
    return list1.joinToString(separator = "", prefix = "", postfix = "")
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int //= TODO()
{
    var ldigits: MutableList<Int> = digits.toMutableList()
    ldigits.reverse()
    var x1: Int = 0
    for (i in 0 until ldigits.size) x1 += ldigits[i] * pow(base.toDouble(), i.toDouble()).toInt()
    return x1
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int //= TODO()
{
    var ldigits: MutableList<Int> = mutableListOf()
    var x3: Int = 0
    for (i in 0 until str.length) {
        when (str[i]) {
            'a' -> x3 = 10
            'b' -> x3 = 11
            'c' -> x3 = 12
            'd' -> x3 = 13
            'e' -> x3 = 14
            'f' -> x3 = 15
            'g' -> x3 = 16
            'h' -> x3 = 17
            'i' -> x3 = 18
            'j' -> x3 = 19
            'k' -> x3 = 20
            'l' -> x3 = 21
            'm' -> x3 = 22
            'n' -> x3 = 23
            'o' -> x3 = 24
            'p' -> x3 = 25
            'q' -> x3 = 26
            'r' -> x3 = 27
            's' -> x3 = 28
            't' -> x3 = 29
            'u' -> x3 = 30
            'v' -> x3 = 31
            'w' -> x3 = 32
            'x' -> x3 = 33
            'y' -> x3 = 34
            'z' -> x3 = 35
            else -> x3 = str[i].toInt() - '0'.toInt()
        }
        ldigits.add(x3)
    }
    ldigits.reverse()
    var x2: Int = 0
    for (i in 0 until ldigits.size) x2 += ldigits[i] * pow(base.toDouble(), i.toDouble()).toInt()
    return x2
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String //= TODO()
{
    var x1:Int = n
    var x2: String = ""
    var list: MutableList<String> = mutableListOf()
    for (i in 1..digitNumber(n)) {
        if (i == 1) when (x1 % 10) {
            1 -> x2 = "I"
            2 -> x2 = "II"
            3 -> x2 = "III"
            4 -> x2 = "IV"
            5 -> x2 = "V"
            6 -> x2 = "VI"
            7 -> x2 = "VII"
            8 -> x2 = "VIII"
            9 -> x2 = "IX"
        }
        if (i == 2) when (x1 % 10) {
            1 -> x2 = "X"
            2 -> x2 = "XX"
            3 -> x2 = "XXX"
            4 -> x2 = "XL"
            5 -> x2 = "L"
            6 -> x2 = "LX"
            7 -> x2 = "LXX"
            8 -> x2 = "LXXX"
            9 -> x2 = "XC"
        }
        if (i == 3) when (x1 % 10) {
            1 -> x2 = "C"
            2 -> x2 = "CC"
            3 -> x2 = "CCC"
            4 -> x2 = "CD"
            5 -> x2 = "D"
            6 -> x2 = "DC"
            7 -> x2 = "DCC"
            8 -> x2 = "DCCC"
            9 -> x2 = "CM"
        }
        if (i == 4) when (x1 % 10) {
            1 -> x2 = "M"
            2 -> x2 = "MM"
            3 -> x2 = "MMM"
        }
        x1 = x1 / 10
        list.add(x2)
    }
    list.reverse()
    return list.joinToString(separator = "", prefix = "", postfix = "")
}

fun digitNumber(n: Int): Int
{
    var x1: Int = kotlin.math.abs(n)
    var x2: Int = 1
    for (i in 1..10) {
        if (x1 / 10 > 0) x2 += 1
        x1 = x1 / 10
    }
    return x2
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String //= TODO()
{
    if (digitNumber(n) <= 3) return russian3digits(n, false)
    var x1: Int = n
    var x3: Int = 0
    var x4: String = ""
    for (i in 1..3) {
        when (i) {
            1 -> x3 = x3 + x1 % 10
            2 -> x3 = x3 + x1 % 10 * 10
            3 -> x3 = x3 + x1 % 10 * 100
        }
        x1 /= 10
    }
    if (n / 1000 % 10 == 1) x4 = " тысяча"
    if (n / 1000 % 10 in 2..4) x4 = " тысячи"
    if (n / 1000 % 10 in 5..9 || n / 1000 % 10 == 0) x4 = " тысяч"
    if (x3 != 0) x4 += " " + russian3digits(x3, false)
    return russian3digits(n / 1000, true) + x4
}

fun russian3digits(n: Int, b: Boolean): String
{
    var x1:Int = n
    var x2: String = ""
    var x1pred: String = ""
    var x2pred: String = ""
    for (i in 1..digitNumber(n)) {
        if (i == 1) {
            when (x1 % 10) {
                0 -> if (!b) x2 = "" else x2 = "ноль"
                1 -> if (b) x2 = "одна" else x2 = "один"
                2 -> if (b) x2 = "две" else x2 = "два"
                3 -> x2 = "три"
                4 -> x2 = "четыре"
                5 -> x2 = "пять"
                6 -> x2 = "шесть"
                7 -> x2 = "семь"
                8 -> x2 = "восемь"
                9 -> x2 = "девять"
            }
            x1pred = x2
        }
        if (i == 2) {
            when (x1 % 10) {
                1 -> when (x1pred) {
                    "ноль" -> x2 = "десять"
                    "один" -> x2 = "одиннадцать"
                    "два" -> x2 = "двенадцать"
                    "три" -> x2 = "тринадцать"
                    "четыре" -> x2 = "четырнадцать"
                    "пять" -> x2 = "пятнадцать"
                    "шесть" -> x2 = "шестнадцать"
                    "семь" -> x2 = "семнадцать"
                    "восемь" -> x2 = "восемнадцать"
                    "девять" -> x2 = "девятнадцать"
                }
                2 -> if (x1pred == "ноль") x2 = "двадцать" else x2 = "двадцать " + x1pred
                3 -> if (x1pred == "ноль") x2 = "тридцать" else x2 = "тридцать " + x1pred
                4 -> if (x1pred == "ноль") x2 = "сорок" else x2 = "сорок " + x1pred
                5 -> if (x1pred == "ноль") x2 = "пятьдесят" else x2 = "пятьдесят " + x1pred
                6 -> if (x1pred == "ноль") x2 = "шестьдесят" else x2 = "шестьдесят " + x1pred
                7 -> if (x1pred == "ноль") x2 = "семьдесят" else x2 = "семьдесят " + x1pred
                8 -> if (x1pred == "ноль") x2 = "восемьдесят" else x2 = "восемьдесят " + x1pred
                9 -> if (x1pred == "ноль") x2 = "девяносто" else x2 = "девяносто " + x1pred
            }
            x2pred = x2
        }
        if (i == 3) {
            val naborD = arrayOf("десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
            when (x1 % 10) {
                1 -> if (x1pred == "ноль") if (x2pred in naborD) x2 = "сто " + x2pred else x2 = "сто" else x2 = "сто " + x2pred
                2 -> if (x1pred == "ноль") if (x2pred in naborD) x2 = "двести " + x2pred else x2 = "двести" else x2 = "двести " + x2pred
                3 -> if (x1pred == "ноль") if (x2pred in naborD) x2 = "триста " + x2pred else x2 = "триста" else x2 = "триста " + x2pred
                4 -> if (x1pred == "ноль") if (x2pred in naborD) x2 = "четыреста " + x2pred else x2 = "четыреста" else x2 = "четыреста " + x2pred
                5 -> if (x1pred == "ноль") if (x2pred in naborD) x2 = "пятьсот " + x2pred else x2 = "пятьсот" else x2 = "пятьсот " + x2pred
                6 -> if (x1pred == "ноль") if (x2pred in naborD) x2 = "шестьсот " + x2pred else x2 = "шестьсот" else x2 = "шестьсот " + x2pred
                7 -> if (x1pred == "ноль") if (x2pred in naborD) x2 = "семьсот " + x2pred else x2 = "семьсот" else x2 = "семьсот " + x2pred
                8 -> if (x1pred == "ноль") if (x2pred in naborD) x2 = "восемьсот " + x2pred else x2 = "восемьсот" else x2 = "восемьсот " + x2pred
                9 -> if (x1pred == "ноль") if (x2pred in naborD) x2 = "девятьсот " + x2pred else x2 = "девятьсот" else x2 = "девятьсот " + x2pred
            }
        }

        x1 = x1 / 10
    }
    return x2
}

