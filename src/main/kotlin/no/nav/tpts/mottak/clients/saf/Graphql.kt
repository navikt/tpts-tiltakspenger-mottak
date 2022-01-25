package no.nav.tpts.mottak.clients.saf

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

object Graphql {

    @Serializable
    data class GraphqlQuery(
        val query: String,
        @Contextual val variables: Any
    )

    interface GraphqlResponse<D> {
        val errors: List<GraphqlError>?
        val data: D?
    }

    data class GraphqlError(
        val message: String? = null,
        val locations: List<GraphqlErrorLocation>? = null,
        val path: List<String>? = null,
        val extensions: GraphqlErrorExtensions? = null
    )

    data class GraphqlErrorLocation(
        val line: Int?,
        val column: Int?
    )

    data class GraphqlErrorExtensions(
        val code: String? = null,
        val classification: String? = null
    )
}