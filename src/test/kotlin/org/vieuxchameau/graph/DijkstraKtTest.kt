package org.vieuxchameau.graph

import com.google.common.graph.ValueGraphBuilder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

typealias DistanceInKm = ULong
typealias City = String

class DijkstraKtTest {
    /**
     * The weight represent the air distance
     */
    private val graph = ValueGraphBuilder.undirected()
            .immutable<City, DistanceInKm>()
            .putEdgeValue("Astana (Kazakhstan)", "Moscow (Russia)", 2_150u)
            .putEdgeValue("Astana (Kazakhstan)", "Beijing (China)", 4_175u)
            .putEdgeValue("Astana (Kazakhstan)", "Delhi (India)", 4_126u)

            .putEdgeValue("Moscow (Russia)", "London (England)", 2_498u)
            .putEdgeValue("Moscow (Russia)", "Barcelona (Spain)", 3_006u)
            .putEdgeValue("Moscow (Russia)", "Algiers (Algeria)", 3_336u)

            .putEdgeValue("Beijing (China)", "Singapore (Singapore)", 4_742u)
            .putEdgeValue("Beijing (China)", "Tokyo (Japan)", 2_098u)

            .putEdgeValue("Delhi (India)", "Singapore (Singapore)", 4_140u)

            .putEdgeValue("London (England)", "Boston (USA)", 5_264u)

            .putEdgeValue("Barcelona (Spain)", "Boston (USA)", 5_861u)

            .putEdgeValue("Algiers (Algeria)", "San Juan (Puerto Rico)", 7_015u)

            .putEdgeValue("Singapore (Singapore)", "Brisbane (Australia)", 6_152u)

            .putEdgeValue("Tokyo (Japan)", "Anchorage (USA)", 5_555u)
            .putEdgeValue("Tokyo (Japan)", "Honolulu (USA)", 6_195u)

            .putEdgeValue("Brisbane (Australia)", "Honolulu (USA)", 7_566u)

            .putEdgeValue("Honolulu (USA)", "San Fransisco (USA)", 3_851u)

            .putEdgeValue("San Juan (Puerto Rico)", "Houston (USA)", 3_178u)
            .putEdgeValue("San Juan (Puerto Rico)", "Helena (USA)", 5_194u)

            .putEdgeValue("Boston (USA)", "Vancouver (Canada)", 4_022u)
            .putEdgeValue("Houston (USA)", "Vancouver (Canada)", 3_184u)
            .putEdgeValue("Helena (USA)", "Vancouver (Canada)", 880u)
            .putEdgeValue("Anchorage (USA)", "Vancouver (Canada)", 2_129u)
            .putEdgeValue("San Fransisco (USA)", "Vancouver (Canada)", 1_276u)
            .build()
    private val dijkstraAlgorithm = DijkstraAlgorithm(graph)


    @Test
    fun `should find the shortest path from Astana (Kazakhstan) to Vancouver (Canada)`() {
        val shortestPath = dijkstraAlgorithm.findShortestPath("Astana (Kazakhstan)", "Vancouver (Canada)")
        println(shortestPath)

        val expectedShortestPath = ShortestPath(13_934u, listOf("Astana (Kazakhstan)", "Moscow (Russia)", "London (England)", "Boston (USA)", "Vancouver (Canada)"))
        assertThat(shortestPath).isEqualTo(expectedShortestPath)

    }

    @Test
    fun `should find the shortest path from Brisbane (Australia) to Moscow (Russia)`() {
        val shortestPath = dijkstraAlgorithm.findShortestPath("Brisbane (Australia)", "Moscow (Russia)")
        println(shortestPath)

        val expectedShortestPath = ShortestPath(16_568u, listOf("Brisbane (Australia)", "Singapore (Singapore)", "Delhi (India)", "Astana (Kazakhstan)", "Moscow (Russia)"))
        assertThat(shortestPath).isEqualTo(expectedShortestPath)

    }


    @Test
    fun `should find the shortest path from Anchorage (USA) to Brisbane (Australia)`() {
        val shortestPath = dijkstraAlgorithm.findShortestPath("Anchorage (USA)", "Brisbane (Australia)")
        println(shortestPath)

        val expectedShortestPath = ShortestPath(14_822u, listOf("Anchorage (USA)", "Vancouver (Canada)", "San Fransisco (USA)", "Honolulu (USA)", "Brisbane (Australia)"))
        assertThat(shortestPath).isEqualTo(expectedShortestPath)

    }

    @Test
    fun `should find correct path for exercise 7-1 A`() {
        val bookGraph = ValueGraphBuilder.directed()
                .immutable<String, ULong>()
                .putEdgeValue("Start", "A", 5u)
                .putEdgeValue("Start", "B", 2u)
                .putEdgeValue("A", "C", 4u)
                .putEdgeValue("A", "D", 2u)
                .putEdgeValue("B", "D", 7u)
                .putEdgeValue("C", "D", 6u)
                .putEdgeValue("C", "FINISH", 3u)
                .putEdgeValue("D", "FINISH", 1u)
                .build()

        val shortestPath = DijkstraAlgorithm(bookGraph).findShortestPath("Start", "FINISH")
        println(shortestPath)

        val expectedShortestPath = ShortestPath(8u, listOf("Start", "A", "D", "FINISH"))
        assertThat(shortestPath).isEqualTo(expectedShortestPath)
    }

    @Test
    fun `should find correct path for exercise 7-1 B`() {
        val bookGraph = ValueGraphBuilder.directed()
                .immutable<String, ULong>()
                .putEdgeValue("Start", "A", 10u)
                .putEdgeValue("A", "C", 20u)
                .putEdgeValue("C", "B", 1u)
                .putEdgeValue("B", "A", 1u)
                .putEdgeValue("C", "FINISH", 30u)
                .build()

        val shortestPath = DijkstraAlgorithm(bookGraph).findShortestPath("Start", "FINISH")
        println(shortestPath)

        val expectedShortestPath = ShortestPath(60u, listOf("Start", "A", "C", "FINISH"))
        assertThat(shortestPath).isEqualTo(expectedShortestPath)
    }
}