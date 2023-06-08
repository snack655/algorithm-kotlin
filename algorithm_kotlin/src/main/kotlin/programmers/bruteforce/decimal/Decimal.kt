package programmers.bruteforce.decimal

fun main() {
    println(solution("143"))
}

fun solution(numbers: String): Int {
    val l = numbers.length
    val dNum = mutableSetOf<Int>()

    for (i in 0 until l) {
        // 먼저 단일 값 확인
        val v = Character.getNumericValue(numbers[i])
        if (v.isPrime()) dNum.add(v)

        val sb = StringBuilder()
        sb.append(numbers[i])

        for (j in 0 until l) {
            if (j == i) continue
            sb.append(numbers[j])
            println("sb : $sb")
            if (sb.toString().toInt().isPrime())
                dNum.add(sb.toString().toInt())
        }
    }
    println(dNum)
    return dNum.size
}

fun Int.isPrime(): Boolean {
    var i = 2
    if (this < 2) return false
    while (i * i <= this) {
        if (this % i++ == 0) return false
    }
    return true
}