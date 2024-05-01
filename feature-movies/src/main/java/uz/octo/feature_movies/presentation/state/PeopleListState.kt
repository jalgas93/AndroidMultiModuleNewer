package uz.octo.feature_movies.presentation.state

import uz.octo.feature_movies.domain.model.People.DomainPeopleItem

class PeopleListState (
    val isLoading: Boolean = false,
    val people: List<DomainPeopleItem> = emptyList(),
    val error: String = ""
)