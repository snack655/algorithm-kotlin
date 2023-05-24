package programmers.stack_queue.process

import java.util.LinkedList
import java.util.Queue

fun main() {
    print(solution(
        priorities = intArrayOf(1, 1, 9, 1, 1, 1),
        location = 0,
    ))
}

fun solution(priorities: IntArray, location: Int): Int {
    var answer = 0
    var count = 0
    val q: Queue<Item> = LinkedList()
    priorities.forEachIndexed { idx, value ->
        q.add(Item(value, idx))
    }
    while (q.isNotEmpty()) {
        val item = q.poll()
        if (q.any { it.priority > item.priority }) {
            // 우선 순위가 더 큰 것이 있다면..
            q.add(item)
        } else {
            count++
            if (item.idx == location)
                answer = count
        }
    }
    return answer
}

data class Item(
    val priority: Int,
    val idx: Int,
) : Comparable<Item> {
    override fun compareTo(other: Item): Int {
        return other.priority - this.priority
    }
}