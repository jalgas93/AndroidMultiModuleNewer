package uz.octo.feature_movies.data.model.Popular
data class Popular(
    val page: Int,
    val results: List<PopularItem>,
    val total_pages: Int,
    val total_results: Int
)