package org.vieuxchameau

import com.google.common.graph.ImmutableGraph
import java.util.*

fun <T> dfs(graph: ImmutableGraph<T>, startingNode: T, predicate: (T) -> Boolean): Boolean {
    val nodesToExplore = Stack<T>().apply {
        addAll(graph.adjacentNodes(startingNode))
    }

    val visitedNodes = mutableSetOf(startingNode)
    while (nodesToExplore.isNotEmpty()) {
        val node = nodesToExplore.pop()
        if (visitedNodes.contains(node)) {
            continue
        }
        println("Visiting $node")
        if (predicate(node)) {
            return true
        }
        nodesToExplore.addAll(graph.adjacentNodes(node))
        visitedNodes.add(node)
    }
    return false
}