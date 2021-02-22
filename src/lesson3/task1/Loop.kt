@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.quadraticRootProduct
import java.lang.Math.abs
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int //= TODO()
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
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int //= TODO()
{
    var xold: Int = 1
    var xoldold: Int = 0
    var x1: Int = 1
    for (i in 2..n) {
        x1 = xold + xoldold
        xoldold = xold
        xold = x1
    }
    return x1
}
/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int //= TODO()
{
    val x1: Int = m * n
    for (i in 1..x1) if (i % m == 0 && i % n == 0) return i
    return 0
}
/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int //= TODO()
{
    for (i in 2..n) if (n % i == 0) return i
    return 0
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int //= TODO()
{
    for (i in n downTo 1)  if (n % i == 0 && i != n) return i
    return 0
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean //= TODO()
{
    if (m > n) for (i in 2..n) if (m % i == 0 && n % i == 0) return false
    if (m < n) for (i in 2..m) if (m % i == 0 && n % i == 0) return false
    if (m == n) for (i in 2..m) if (m % i == 0 && n % i == 0) return false
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean //= TODO()
{
    val x1: Int = sqrt(n.toDouble()).toInt()
    if (m == 0 && n == 0) return true
    for (i in 1..x1) if (i * i in m..n) return true
    return false
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int //= TODO()
{
    var xNext: Int = x
    if (x == 1) return 0
    for (i in 1..1000) {
        if (xNext % 2 == 0) xNext /= 2 else xNext = 3 * xNext + 1
        if (xNext == 1) return i
    }
    return 0
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int //= TODO()
{
    var x1:Int = 0
    var x2:Int = n
    var k:Int = 0
    for (i in 1..10) {
        k = x2 % 10
        x1 = x1 * 10 + k
        if (x2 / 10 < 1) return x1 else x2 /= 10
    }
    return 0
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean //= TODO()
{
    if (n == revert(n)) return true
    return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean //= TODO()
{
    var x1:Int = n
    var oldx1:Int = x1 % 10
    for (i in 1..10) {
        if (x1 / 10 < 1) return false
        if (x1 / 10 % 10 != oldx1 ) return true
        x1 = x1 /10
        oldx1 = x1 % 10
    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int //= TODO()
{
    var x1: Int = 0
    for (i in 1..n) {
        x1 = digitNumber(i * i) + x1
        if (x1 == n) return i * i % 10
        if (x1 > n) return digitOfnumber(i * i, (x1 - n))
    }
    return 0
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int //= TODO()
{
    var x1:Int = 0
    for (i in 1..n) {
        x1 = digitNumber(fib(i)) + x1
        if (x1 == n) return fib(i) % 10
        if (x1 > n) return digitOfnumber(fib(i), (x1 - n))
    }
    return 0
}

fun digitOfnumber(a: Int, b: Int): Int
{
    var c: Int = a
    for (i in 1..b) c /= 10
    c %= 10
    return c
}

