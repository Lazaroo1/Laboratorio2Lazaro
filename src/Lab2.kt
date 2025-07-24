/*
 * Universidad del Valle de Guatemala
 * Programación de plataformas móviles
 * Laboratorio 2, Lázaro Diaz 24713
 */

package edu.uvg.mobile.lab2

data class Person(val name: String, val age: Int, val gender: String)
data class Student(
    val name: String,
    val age: Int,
    val gender: String,
    val studentId: String
)

// Calcular el producto de una lista de números usando reduce
fun calculateProduct(numbers: List<Int>): Int =
    numbers.reduce { acc, num -> acc * num }

// Devolver el promedio de una lista
fun calculateAverage(numbers: List<Double>): Double =
    if (numbers.isEmpty()) 0.0
    else numbers.reduce { acc, num -> acc + num } / numbers.size

// Filtrar números impares de una lista
fun filterOdd(numbers: List<Int>): List<Int> =
    numbers.filter { it % 2 != 0 }

// Ver si una cadena es palindroma
fun isPalindrome(text: String): Boolean =
    text.filter { it.isLetterOrDigit() }
        .lowercase()
        .let { cleaned -> cleaned == cleaned.reversed() }

// Un saludo a cada nombre usando map con parámetro de saludo por default
fun greetNames(
    nombres: List<String>,
    saludo: String = "¡Hola"
): List<String> =
    nombres.map { name -> "$saludo, $name!" }

// Función que aplica una operación entre dos números
fun performOperation(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int = { x, y -> x + y }
): Int = operation(a, b)

// Mapeo de Person a Student
fun mapToStudent(
    people: List<Person>,
    defaultIdProvider: (Person) -> String = { person ->
        person.name.lowercase().replace(" ", "_") + "_ID"
    }
): List<Student> =
    people.map { person ->
        Student(
            name = person.name,
            age = person.age,
            gender = person.gender,
            studentId = defaultIdProvider(person)
        ).also { student ->
            println("El estudiante ${student.name} tiene ${student.age} años.")
        }
    }

fun main() {
    val ints = listOf(90,1, 2, 3, 4, 5, 4444, 4532,2342, 332039310)
    println("Producto: ${calculateProduct(ints)}")

    val doubles = listOf(2.222, 4.789, 6.12088)
    println("Promedio: ${calculateAverage(doubles)}")

    println("Impares: ${filterOdd(ints)}")

    println("Radar es palindromo? ${isPalindrome("Radar")} ")

    val names = listOf("Billie Eilish", "Dua Lipa", "Nicki Nicole")
    println(greetNames(names))

    println("Suma: ${performOperation(5, 3)}")
    println("Multiplicar: ${performOperation(5, 3) { x, y -> x * y }}")

    val people = listOf(
        Person("Lazaro", 19, "M"),
        Person("Alejandra", 22, "F")
    )
    mapToStudent(people)
}
