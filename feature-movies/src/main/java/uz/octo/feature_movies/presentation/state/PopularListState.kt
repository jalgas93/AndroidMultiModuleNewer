package uz.octo.feature_movies.presentation.state

import uz.octo.feature_movies.domain.model.Result

data class PopularListState(
    val isLoading: Boolean = false,
    val movies: List<Result> = emptyList(),
    val error: String = ""
)
