@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import kotlin.math.*
import kotlin.Double as Double1

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double1) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double1, b: Double1, c: Double1) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double1, b: Double1, c: Double1) =
    (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double1, b: Double1, c: Double1): Double1 {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main() {
    val x1x2 = quadraticRootProduct(1.0, 13.0, 42.0)
    println("Root product: $x1x2")
    println()
/*    println(seconds(8, 20, 35)) // 30035

    val result = sqr (7)
    println("7 * 7 = $result") // 7 * 7 = 49

    println(angleInRadian(36, 14, 35)) // 0.63256

    println(thirdDigit(3801)) // 8

    println(lengthInMeters(8, 2, 11)) // 18.98

    println(trackLength(3.0, 0.0, 0.0, 4.0)) // 5

    println(travelMinutes(9, 25, 13, 1)) // 216

    println(accountInThreeYears(100, 10)) // 133.1

    println(numberRevert(478)) // 874

*/
}

/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int // = TODO()
{
   return (((hours * 60) + minutes) * 60) + seconds
}

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double1 //= TODO()
{
    return ((sagenes * 48) + (arshins * 16) + vershoks) * 0.04445
}
/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(deg: Int, min: Int, sec: Int): Double1 //= TODO()
{
    return (deg * (PI / 180)) + (min * (PI / (180 * 60))) + (sec * (PI / (180 * 60 *60)))
}
/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double1, y1: Double1, x2: Double1, y2: Double1): Double1 //= TODO()
{
    return sqrt (sqr(x1 - x2) + sqr(y1 - y2))
}
/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int // = TODO()
{
   return (number / 100) % 10
}
/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int //= TODO()
{
    return ((hoursArrive * 60) + minutesArrive) - ((hoursDepart * 60) + minutesDepart)
}
/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double1 //= TODO()
{
    return initial.toDouble() * (1 + percent.toDouble() / 100).pow(3.0)
}
/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int //= TODO()
{
    return ((number % 10) * 100) + (((number / 10) % 10) * 10) + (number / 100)
}