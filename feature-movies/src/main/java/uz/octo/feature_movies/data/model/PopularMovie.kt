
data class PopularMovie(
    val page: Int,
    val results: List<ResultModel>,
    val total_pages: Int,
    val total_results: Int
)