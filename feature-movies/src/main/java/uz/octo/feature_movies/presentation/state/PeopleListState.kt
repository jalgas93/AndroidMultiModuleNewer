package uz.octo.feature_movies.presentation.state

import uz.octo.feature_movies.domain.model.PopularMovie.Result
import uz.octo.feature_movies.domain.model.PopularPeople.People

class PeopleListState (
    val isLoading: Boolean = false,
    val movies: List<People> = emptyList(),
    val error: String = ""
)