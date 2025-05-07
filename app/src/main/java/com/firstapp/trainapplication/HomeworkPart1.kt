package com.firstapp.trainapplication

import kotlin.math.pow

val months = arrayOf (
"January", "February", "March", "April",
"May", "June", "July", "August",
"September", "October", "November", "December"
)
val vowels = arrayOf('A', 'E', 'I', 'O', 'U', 'Y')
var middleName: String? = "Pepper"
fun main(args: Array<String>) {
    task1(14)
    task2(23)
    task3(-24)
    task4('o')
    task5(15)
    task6(arrayOf("London", "Paris", "Prague", "Rim", "Berlin"))
    task7("This text could be in Russian, but coding does not work for me.")
    task8(mutableListOf(3, Int.MIN_VALUE, 4, 2, 0, 5, 0))
    task9(List(334) {3})
    task10(2047)
    task11()
}

/**
 *В переменной celsius хранится целое число — температура воздуха.
 * Выведите в консоль:
 * ○ «Freezing», если celsius ≤ 0;
 * ○ «Cool», если 1 ≤ celsius ≤ 15;
 * ○ «Warm», если 16 ≤ celsius ≤ 25;
 * ○ «Hot», если celsius > 25
 */
fun task1(celsius: Int) {
    when {
        celsius <= 0 -> println("Freezing")
        celsius <= 15 -> println("Cool")
        celsius <= 25 -> println("Warm")
        else -> println("Hot")
    }
}

/**
 * Пассажир сообщает свой возраст в переменной age.
 * Определите стоимость билета по тарифам и выведите найденную стоимость:
 * ○ до 7 лет (включительно) — 0 ₽,
 * ○ 8–17 лет — 15 ₽,
 * ○ 18–60 лет — 30 ₽,
 * ○ старше 60 лет — 20 ₽.
 */
fun task2(age: Int) {
    when {
        age <= 7 -> println("0Р")
        age <= 17 -> println("15Р")
        age <= 60 -> println("30Р")
        else -> println("20Р")
    }
}

/**
 * В переменной month дан номер месяца (1–12).
 * Напечатайте название времени года на английском: «Winter», «Spring», «Summer»
 * или «Autumn».
 */
fun task3(month: Int) {
    var monthReal = month
    while(monthReal <= 0) {
        monthReal += 12
    }
    while(monthReal > 12) {
        monthReal -= 12
    }
    monthReal--
    println(months[monthReal])
}
/**
 *  Следующая буква
 * В переменной ch хранится одна заглавная латинская буква (A – Z). Выведите строку
 * «YES», если эта буква относится к гласным (A, E, I, O, U, Y), и «NO» в противном
 * случае.
 */
fun task4(ch: Char) {
    when(ch.uppercase().toCharArray()[0]) {
        'A', 'E', 'I', 'O', 'U', 'Y' -> println("YES")
        else -> println("NO")
    }
}
/**
 *Пользователь вводит число n (1–9).
 * Выведите в одной строке через пробел значения n × 1, n × 2, …, n × 10.
 */
fun task5(n: Int) {
    for (i in n..(10*n) step n)
        print("$i ")
    println()
}
/**
 *В коде объявлен массив cities из пяти названий городов.
 * Выведите их по одному на строке в обратном порядке (последний → первый).
 */
fun task6(cities: Array<String>) {
    for (i in cities.size - 1 downTo 0)
        println(cities[i])
}
/**
 * Вводится произвольная строка text.
 * Посчитайте и выведите количество русских гласных букв
 * («аоиеёэыуюя», регистр неважен).
 */
fun task7(text: String) {
    var upperText = text.uppercase()
    var counter = 0
    for (ch in upperText) {
        counter += if (ch in vowels) 1 else 0
    }
    println(counter)
}
/**
 * Есть изменяемый список целых чисел numbers: MutableList<Int>. Последний
 * элемент списка равен 0. Определите наименьшее значение среди всех элементов,
 * стоящих до этого нуля, и запишите результат в переменную minValue: Int.
 */
fun task8(numbers: MutableList<Int>) {
    var minValue = Int.MAX_VALUE
    for (i in numbers) {
        if (i == 0) break
        minValue = minValue.coerceAtMost(i)
    }
    println(minValue)
}
/**
 * Дан список целых чисел data: List<Int>.
 * Просматривайте элементы по порядку, накапливая их сумму в переменной total:
 * Int, до тех пор, пока total не станет больше 1000. По завершении работы
 * программы в total должно находиться получившееся итоговое значение.
 */
fun task9(data: List<Int>) {
    var total = 0
    for (i in data) {
        if (total + i > 1000) break
        total += i
    }
    println(total)
}
/**
 * Задано натуральное число k: Int. Найдите наименьшую степень двойки 2^m,
 * которая не меньше k, и сохраните это значение в переменной closestPower: Int.
 * Число m выводить или сохранять не требуется.
 */
fun task10(k: Int){
    var result = 0
    while (1 shl result < k)
        result++
    println(1 shl result)
}
/**
 * В коде уже объявлена переменная middleName: String? = null.
 * Напечатайте строку вида «Количество символов = X»,
 * где X — длина middleName, если значение не null,
 * или 0, если переменная равна null.
 */
fun task11() {
    println(middleName?.length ?: 0)
}