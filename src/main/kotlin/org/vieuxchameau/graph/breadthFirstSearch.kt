package org.vieuxchameau.graph

import com.google.common.graph.ImmutableGraph
import java.util.*

/**
 * Apply to find if two nodes are connected in an unweighted graph.
 * Will find the shortest path between them
 * @param graph an unweighted graph
 * @param startingNode the node from which to start
 * @param predicate to determine if the destination is reached
 */
fun <T> bfs(graph: ImmutableGraph<T>, startingNode: T, predicate: (T) -> Boolean): Boolean {
    val nodesToExplore: Queue<T> = LinkedList<T>(graph.adjacentNodes(startingNode))
    val visitedNodes = mutableSetOf(startingNode)
    while (nodesToExplore.isNotEmpty()) {
        val node = nodesToExplore.poll()
        if (!visitedNodes.contains(node)) {
            println("Visiting $node")
            if (predicate(node)) {
                return true
            }
            nodesToExplore.addAll(graph.adjacentNodes(node))
            visitedNodes.add(node)
        }
    }
    return false
}
