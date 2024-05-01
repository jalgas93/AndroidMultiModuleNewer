package uz.octo.feature_movies.data.model.People

data class People(
    val page: Int,
    val results: List<PeopleItem>,
    val total_pages: Int,
    val total_results: Int
)