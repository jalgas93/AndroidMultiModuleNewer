package uz.octo.feature_movies.domain.model.People

import uz.octo.feature_movies.data.model.People.KnownFor

data class DomainPeopleItem(
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
