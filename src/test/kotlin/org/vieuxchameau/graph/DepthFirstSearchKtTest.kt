package org.vieuxchameau.graph

import com.google.common.graph.GraphBuilder
import com.google.common.graph.ImmutableGraph
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.vieuxchameau.graph.dfs

class DepthFirstSearchKtTest {
    private val countriesWithLandBorderNeighbours: ImmutableGraph<String> = GraphBuilder.undirected()
            .immutable<String>()
            .putEdge("Canada", "United States of America")
            .putEdge("United States of America", "Mexico")
            .putEdge("Mexico", "Belize")
            .putEdge("Mexico", "Guatemala")
            .putEdge("Belize", "Guatemala")
            .putEdge("Guatemala", "El Salvador")
            .putEdge("Guatemala", "Honduras")
            .putEdge("Honduras", "El Salvador")
            .putEdge("Honduras", "Nicaragua")
            .putEdge("Nicaragua", "Costa Rica")
            .putEdge("Costa Rica", "Panama")
            .putEdge("Panama", "Colombia")
            .putEdge("Colombia", "Brazil")
            .putEdge("Colombia", "Ecuador")
            .putEdge("Colombia", "Peru")
            .putEdge("Colombia", "Venezuela")
            .putEdge("Brazil", "Argentina")
            .putEdge("Brazil", "Bolivia")
            .putEdge("Brazil", "Guyana")
            .putEdge("Brazil", "Paraguay")
            .putEdge("Brazil", "Peru")
            .putEdge("Brazil", "Suriname")
            .putEdge("Brazil", "Uruguay")
            .putEdge("Brazil", "Venezuela")
            .putEdge("Ecuador", "Peru")
            .putEdge("Peru", "Bolivia")
            .putEdge("Peru", "Chile")
            .putEdge("Venezuela", "Guyana")
            .putEdge("Argentina", "Bolivia")
            .putEdge("Argentina", "Chile")
            .putEdge("Argentina", "Paraguay")
            .putEdge("Argentina", "Uruguay")
            .putEdge("Bolivia", "Chile")
            .putEdge("Bolivia", "Paraguay")
            .putEdge("Guyana", "Suriname")
            .addNode("Australia")
            .build()


    @CsvSource(
            "Canada, Uruguay",
            "Uruguay, Canada",
            "Mexico, Panama"
    )
    @ParameterizedTest
    fun `should find that countries are connected by land`(source: String, target: String) {
        val isCountry: (String) -> Boolean = { it == target }

        val areConnected = dfs(countriesWithLandBorderNeighbours, source, isCountry)

        Assertions.assertThat(areConnected).isTrue()
    }

    @CsvSource(
            "Canada, Australia",
            "Australia, Panama"
    )
    @ParameterizedTest
    fun `should find that countries are not connected by land`(source: String, target: String) {
        val isCountry: (String) -> Boolean = { it == target }

        val areConnected = dfs(countriesWithLandBorderNeighbours, source, isCountry)

        Assertions.assertThat(areConnected).isFalse()
    }
}