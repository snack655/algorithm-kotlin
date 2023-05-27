package programmers.greedy

fun main() {
    println(solution("4177252841", 4)) // "775841"
}

fun solution(number: String, k: Int): String {
    var answer = StringBuilder()
    var idx = 0

    for (i in 0 until number.length - k) {
        var max = '0'
        println("idx : $i, max j : ${i+4}")
        for (j in idx..i+k) {
            if (max < number[j]) {
                println("number[$j] : ${number[j]}")
                max = number[j]
                idx = j + 1
            }
        }
        println("-----out-----")
        answer.append(max)
    }
    return answer.toString()
}