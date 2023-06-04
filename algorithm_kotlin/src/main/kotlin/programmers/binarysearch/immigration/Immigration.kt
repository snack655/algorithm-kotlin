package programmers.binarysearch.immigration

fun main() {
    println(solution(n = 6, times = intArrayOf(7, 10)))
}

fun solution(n: Int, times: IntArray): Long {
    times.sort()
    var answer: Long = 0

    var min = 1L
    var max = times[times.size - 1] * n.toLong()

    while (min <= max) {
        // 얼마나 많은 사람을 검사할 수 있는지..
        var people = 0L
        var mid = (min + max) / 2

        for (time in times) {
            people += mid / time
            if (people >= n)
                break
        }

        if (people >= n) {
            answer = mid
            max = mid - 1
        } else {
            min = mid + 1
        }
    }
    return answer
}
