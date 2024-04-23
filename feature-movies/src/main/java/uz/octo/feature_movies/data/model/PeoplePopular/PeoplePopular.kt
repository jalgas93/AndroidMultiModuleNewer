package uz.octo.feature_movies.data.model.PeoplePopular

data class PeoplePopular(
    val page: Int,
    val results: List<ResultPeople>,
    val total_pages: Int,
    val total_results: Int
)