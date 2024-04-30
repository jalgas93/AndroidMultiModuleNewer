package uz.octo.feature_movies.presentation.state

import uz.octo.feature_movies.domain.model.PopularMovie.Result
import uz.octo.feature_movies.domain.model.genres.Genre

class GenresListState(
    val isLoading: Boolean = false,
    val genres: List<Genre> = emptyList(),
    val error: String = ""
)