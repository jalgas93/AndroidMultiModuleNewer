package uz.octo.feature_movies.presentation.state

import uz.octo.feature_movies.domain.model.details.DomainDetails

class DetailsState (
    val isLoading: Boolean = false,
    val details:DomainDetails? = null,
    val error: String = ""
)