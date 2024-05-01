package uz.octo.feature_movies.presentation.state

import uz.octo.feature_movies.domain.model.Popular.DomainPopularItem

data class PopularListState<T>(
    val isLoading: Boolean = false,
    val movies: List<T> = emptyList(),
    val error: String = ""
)
