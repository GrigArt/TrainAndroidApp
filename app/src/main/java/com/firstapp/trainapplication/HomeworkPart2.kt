package com.firstapp.trainapplication

import kotlin.math.abs
import kotlin.math.pow

fun main(args: Array<String>) {
    task12("123")
    task13()
    task14()
    task15()
    task16()
    task17()
    task18(listOf("AX23X", "BT77", "QX90X"))
    task19()
    task20()
    task21()
    task22()
}

/**
 * Напишите функцию welcomeBot(id: String), которая выводит строку
 * Beep! Unit <id> online
 */
fun task12(id: String) {
    println("task12")
    println("Beep! Unit $id online")
}

/**
 * Создайте функцию orderPaint(color: String = "silver", layers: Int = 1), печатающую
 * строку
 * Painting robot in <color> (layers: <layers>).
 * Если аргументы не переданы — используются значения по умолчанию.
 * Если layers ≤ 0, функция должна вывести сообщение об ошибке "Invalid number of
 * layers"
 */
fun task13(color: String = "silver", layers: Int = 1) {
    println("task13")
    if (layers <= 0)
        throw IllegalArgumentException("Invalid number of layers")
    else
        println("Painting robot in $color (layers: $layers).")
}

/**
 * Объявите компактную функцию triple(x: Int): Int = x * 3.
 * Затем реализуйте функцию sumOfTriples(n: Int): Int, которая для каждого i из
 * диапазона 1..n вызывает triple(i) и выводит полученную сумму
 */
fun task14() {
    println("task14")
    fun sumOfTriples(n: Int) {
        val triple: (Int) -> Int = {x -> x * 3}
        var s = 0
        for (i in 1..n)
            s += triple(i)
        println(s)
    }
    sumOfTriples(-6)
    sumOfTriples(3)
}
/**
 * Объявите переменную boost: (Int) -> Int, которая для чётных аргументов
 * возвращает их куб, для нечётных — квадрат; если модуль результата превышает
 * 1_000_000, вместо числа выводится сообщение об ошибке "Out of range";
 * продемонстрируйте работу, вызвав boost(4) и выведя полученный результат
 */
fun task15() {
    println("task15")
    val boost: (Int) -> Int = { x ->
        val res = if (x % 2 == 0) x.toDouble().pow(3) else x.toDouble().pow(2)
        if (res > 1000000) throw Exception("Out of range")
        res.toInt()
    }
    println(boost(4))
}

/**
 * Реализуйте функцию combine(a: Int, b: Int, operation: (Int, Int) -> Int): Int, которая
 * применяет переданную в параметре operation функцию к значениям a и b, если оба
 * числа положительные, иначе возвращает результат применения функции operation
 * к их модулям, и выведите результат
 */
fun task16() {
    println("task16")
    fun combine(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(abs(a), abs(b))
    }
    println(combine(1,2,::minOf))
    println(combine(1,-2,::minOf))
}
/**
 * Создайте функцию wrapInHashes(text: String): String, добавляющую по одному
 * символу # в начало и конец строки. Передайте её как ссылку ::wrapInHashes вторым
 * аргументом в функцию secureText, которая должна вызвать полученную функцию и
 * вывести преобразованный текст
 */
fun task17() {
    println("task17")
    fun wrapInHashes(text: String): String {
        return "#$text#"
    }

    fun secureText(text: String, method: (String) -> String) {
        println(method(text))
    }
    secureText("1 = 1", ::wrapInHashes)
    secureText("SELECT password FROM users WHERE users.name = \"admin\" LIMIT 1", ::wrapInHashes)
}

/**
 * В коде объявлен список drones, например listOf("AX23X", "BT77", "QX90X"),
 * отфильтруйте элементы, оставив только те, что оканчиваются символом 'X' и при
 * этом содержат не менее пяти символов, затем преобразуйте их в нижний регистр и
 * выведите получившийся список
 */
fun task18(drones: List<String>) {
    println("task18")
    val res = drones
        .filter {it.length >= 5 && it.last() == 'X'}
        .map {it.lowercase()}
    println(res)
}

/**
 * Напишите функцию computeFibonacci(n: Int?): Int?, которая возвращает n-е число
 * Фибоначчи, если n не равен null и неотрицательно, при этом для значений n от 0 до
 * 1 возвращается n, а для остальных — рекурсивно вычисляется сумма двух
 * предыдущих чисел; если n меньше 0 или равно null, функция должна вернуть null,
 * выведите результаты для нескольких значений n, включая null и отрицательные
 * числа
 */
fun task19() {
    println("task19")
    fun computeFibonacci(n: Int?): Int? {
        if (n == null || n < 0) {
            return null
        }
        if (n <= 1) {
            return 1
        }
        return (computeFibonacci(n-1)?:0) + (computeFibonacci(n-2)?:0)

    }
    println(computeFibonacci(-3))
    println(computeFibonacci(null))
    println(computeFibonacci(5))
}

/**
 * Создайте функцию findMinCharge(levels: List<Int>?): Int?, которая возвращает
 * минимальный уровень заряда батарей из переданного списка, при этом функция
 * должна игнорировать все отрицательные значения и возвращать null, если список
 * равен null, пустой или не содержит ни одного положительного значения; выведите
 * результат для примера с положительными, отрицательными и нулевыми
 * значениями
 */
fun task20() {
    println("task20")
    fun findMinCharge(levels: List<Int>?): Int? {
        if (levels == null) return null
        var min = Int.MAX_VALUE
        for (i in levels) {
            if (i >= 0 && i < min) min = i
        }
        if (min == Int.MAX_VALUE)
            return null
        return min
    }
    println(findMinCharge(null))
    println(findMinCharge(listOf(-1,-2,-2)))
    println(findMinCharge(List(10) { 10 - it }))
}

/**
 * Реализуйте функцию sumValid(values: List<Int?>): Int, которая суммирует все
 * элементы списка, игнорируя значения null и те, что меньше нуля, и выводит
 * итоговое значение суммы только положительных чисел
 */
fun task21() {
    println("task21")
    fun sumValid(values: List<Int?>): Int {
        var s = 0
        for (i in values) {
            if (i != null && i >= 0) s += i
        }
        return s
    }
    println(sumValid(List(10) {it-5}))
}

/**
 * Напишите функцию adjustSignals(signals: List<Int>, adjust: (Int) -> Int = { it * 2 }):
 * List<Int>, которая применяет к каждому элементу списка signals функцию adjust (по
 * умолчанию — удвоение), исключая из обработки отрицательные значения, и
 * возвращает новый список преобразованных положительных чисел; проверьте
 * работу функции как с преобразованием по умолчанию, так и с передачей лямбды,
 * умножающей элемент на 10
 */
fun task22() {
    println("task22")
    fun adjustSignals(signals: List<Int>, adjust: (Int) -> Int = { it * 2 }): List<Int> {
        var modSignals = signals
            .filter { it >= 0 }
            .map { adjust(it) }
        return modSignals
    }
    println(adjustSignals(List(10) {it-5}))
    println(adjustSignals(List(10) {it-5},{it * 10}))
}