package uz.octo.feature_movies.presentation.state

import uz.octo.feature_movies.domain.model.genre.DomainGenreItem

class GenresListState(
    val isLoading: Boolean = false,
    val domainGenreItems: List<DomainGenreItem> = emptyList(),
    val error: String = ""
)