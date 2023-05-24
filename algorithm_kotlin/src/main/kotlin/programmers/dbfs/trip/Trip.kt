package programmers.dbfs.trip

fun main() {
    print(
        solution(
        arrayOf(
            arrayOf("ICN", "JFK"),
            arrayOf("HND", "IAD"),
            arrayOf("JFK", "HND"),
        )
    )
    )
}

lateinit var visit: MutableList<Boolean>
val answer = mutableListOf<String>()
val temp = mutableListOf<String>()
lateinit var tickets_ : Array<Array<String>>

fun solution(tickets: Array<Array<String>>): Array<String> {
    visit = MutableList(tickets.size) { false }
    tickets.sortBy { it[1] } // 알파벳 순서가 앞서는 경로 return 하기 위함
    tickets_ = tickets
    dfs("ICN", 0)
    return answer.toTypedArray()
}

fun dfs(str: String, x: Int) : Boolean {
    temp.add(str)

    if (x == tickets_.size) {
        answer.addAll(temp)
        return true
    }

    for (i in tickets_.indices) {
        // 현재 위치와 같고, 사용하지 않은 티켓일 때
        if (tickets_[i][0] == str && !visit[i]) {
            visit[i] = true
            if (dfs(tickets_[i][1], x + 1)) return true
            // 탐색 실패 시 방문 처리 취소
            visit[i] = false
        }
    }
    temp.removeAt(temp.size - 1)
    return false
}