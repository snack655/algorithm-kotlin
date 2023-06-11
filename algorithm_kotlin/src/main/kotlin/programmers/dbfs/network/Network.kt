package programmers.dbfs.network

lateinit var visited: MutableList<Boolean>

fun netDFS(node: Int, computers: Array<IntArray>) {
    visited[node] = true

    computers[node].forEachIndexed { idx, com ->
        if (com > 0 && idx != node && !visited[idx])
            netDFS(idx, computers)
    }
}

fun solution(n: Int, computers: Array<IntArray>): Int {
    var answer = 1
    var startNode = 0
    visited = MutableList(n) { false }

    while (true) {
        netDFS(startNode, computers)
        if (visited.contains(false)) {
            startNode = visited.indexOf(false)
            answer += 1
        } else {
            break
        }
    }
    return answer
}

fun main() {
    println(
        solution(
            3,
            arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 0, 1),
            )
        )
    )
}