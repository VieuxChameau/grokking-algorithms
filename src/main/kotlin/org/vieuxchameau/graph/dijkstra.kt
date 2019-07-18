package org.vieuxchameau.graph

import com.google.common.graph.ImmutableValueGraph


/**
 * Dijkstra is used to calculate the shortest path on a weighted graph (Directed or not).
 * It works when the all edges' weight are positives
 */
class DijkstraAlgorithm<T>(private val graph: ImmutableValueGraph<T, ULong>) {
    fun findShortestPath(fromNode: T, toNode: T): ShortestPath<T> {
        var nodeToVisit: T? = fromNode
        val statusTable = buildStatusTable()

        val status = statusTable.getValue(fromNode)
        status.cost = 0u

        val visitedNodes = mutableSetOf<T>()
        do {
            visitedNodes.add(nodeToVisit!!)
            val neighbourNodes = graph.successors(nodeToVisit)

            for (neighbourNode in neighbourNodes) {
                val edgeValue = graph.edgeValue(nodeToVisit, neighbourNode)
                updateStatusTable(nodeToVisit, neighbourNode, edgeValue.get(), statusTable)
            }

            nodeToVisit = getNextNodeToVisit(statusTable, visitedNodes)
        } while (nodeToVisit != null)

        return build(statusTable, toNode)
    }

    private fun build(statusTable: Map<T, Status<T>>, target: T): ShortestPath<T> {
        val path = mutableListOf<T>()
        var parent: T? = target
        while (parent != null) {
            path.add(parent)
            parent = statusTable.getValue(parent).parent
        }
        return ShortestPath(statusTable.getValue(target).cost!!, path.asReversed())
    }

    private fun updateStatusTable(nodeToVisit: T, neighbourNode: T, edgeValue: ULong, statusTable: Map<T, Status<T>>) {
        val (_, _, cost) = statusTable.getValue(nodeToVisit)
        val neighbourStatus = statusTable.getValue(neighbourNode)

        val newCost = cost?.plus(edgeValue) ?: edgeValue
        if (neighbourStatus.cost == null || neighbourStatus.cost!! > newCost) {
            neighbourStatus.parent = nodeToVisit
            neighbourStatus.cost = newCost
        }
    }

    /**
     * This will return the next node to visit that has not been explored with the smallest cost or null
     * if everything has been explored
     */
    private fun getNextNodeToVisit(statusTable: Map<T, Status<T>>, visitedNodes: Set<T>): T? {
        return statusTable.values.filter { !visitedNodes.contains(it.node) }
                .filter { it.cost != null }
                .minBy { it.cost!! }
                ?.node
    }

    private fun buildStatusTable(): Map<T, Status<T>> {
        return graph.nodes().map { it to Status(it) }.toMap()
    }

    private data class Status<T>(val node: T, var parent: T? = null, var cost: ULong? = null)


}

data class ShortestPath<T>(val totalWeight: ULong, val path: List<T>)