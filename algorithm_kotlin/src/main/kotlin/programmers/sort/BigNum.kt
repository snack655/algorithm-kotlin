package programmers.sort

import java.lang.StringBuilder

fun main() {
    //println(solution(intArrayOf(3, 30, 34, 5, 9))) // 9534330
    println(solution2(intArrayOf(3, 30, 34, 5, 9))) // 9534330
}

fun solution(numbers: IntArray): String {
    var answer = StringBuilder()
    val onumbers = emptyList<Number>().toMutableList()
    val maxLength = numbers.max().toString().length
    numbers.forEachIndexed { idx, v ->
        if (v.toString().length == maxLength) {
            onumbers.add(Number(v.toString(), idx))
        } else {
            var value = v.toString()
            val c = value[value.lastIndex]
            for (i in 0 until maxLength - value.length)
                value += c
            onumbers.add(Number(value, idx))
        }
    }
    val snumbers = onumbers.sortedByDescending { it.value.toInt() }
    if (snumbers[0].value == "0")
        return "0"
    snumbers.forEach {
        println(numbers[it.idx].toString())
        answer.append(numbers[it.idx].toString())
    }
    return answer.toString()
}

data class Number(
    val value: String,
    val idx: Int,
)

/**
 * 길이가 같을 경우에는 o1, o2 둘 중에서 본질적으로 큰 것을 내림차순으로 정렬하면 되고
 * 길이가 다른 경우에는 o1o2 o2o1 비교해서 큰 것을 내림차순으로 정렬... 하... 이렇게 쉬운 건ㄷ..
 */
fun solution2(numbers: IntArray): String {
    var answer = "0"

    var temp = arrayOf<String>()
    numbers.forEach {
        temp += it.toString()
    }

    temp.sortWith { o1, o2 ->
        when (o1.length) {
            o2.length -> o2.compareTo(o1)
            else -> (o2 + o1).compareTo(o1 + o2)
        }
    }

    if (temp[0] == "0") {
        return answer
    } else {
        answer = ""
        temp.forEach {
            answer += it
        }
    }

    return answer
}
