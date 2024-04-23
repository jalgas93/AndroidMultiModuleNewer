package uz.octo.feature_movies.data.model.PopularMovie
data class PopularMovie(
    val page: Int,
    val results: List<ResultModel>,
    val total_pages: Int,
    val total_results: Int
)