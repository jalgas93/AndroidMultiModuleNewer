package uz.octo.feature_movies.data.model.category

data class Category(
    val page: Int,
    val results: List<CategoryItem>,
    val total_pages: Int,
    val total_results: Int
)