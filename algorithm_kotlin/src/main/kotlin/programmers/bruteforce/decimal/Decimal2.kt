package programmers.bruteforce.decimal

lateinit var set: MutableSet<Int>

fun main() {
    println(solution2("011"))
}

fun solution2(numbers: String): Int {
    set = mutableSetOf()
    getCombination(numbers, "")
    return set.count { it.isPrime() }
}

fun getCombination(numbers: String, result: String) {
    if (result.isNotEmpty()) set.add(result.toInt())
    if (numbers.isEmpty()) return
    numbers.forEachIndexed { index, c ->
        getCombination(numbers.removeRange(index..index), c.plus(result))
    }
}