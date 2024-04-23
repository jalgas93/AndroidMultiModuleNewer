package uz.octo.feature_movies.domain.model.PopularPeople

import uz.octo.feature_movies.data.model.PeoplePopular.KnownFor

data class People(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownFor>,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)
