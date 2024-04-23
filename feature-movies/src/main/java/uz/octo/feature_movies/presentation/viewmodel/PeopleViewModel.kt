package uz.octo.feature_movies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.GetPopularUseCase.GetPeoplePopularUseCase
import uz.octo.feature_movies.domain.GetPopularUseCase.GetPopularUseCase
import uz.octo.feature_movies.presentation.state.PeopleListState
import uz.octo.feature_movies.presentation.state.PopularListState
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeoplePopularUseCase
) :
    ViewModel() {
    private val _state = MutableLiveData<PeopleListState>()
    val state: LiveData<PeopleListState> = _state

    init {
        getPeoplePopular()
    }

    private fun getPeoplePopular() {

        getPeopleUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PeopleListState(movies = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        PeopleListState(error = result.message ?: "An unexpected error occurred!")
                }

                is Resource.Loading -> {
                    _state.value = PeopleListState(isLoading = true)
                }

                else -> {}
            }

        }.launchIn(viewModelScope)
    }

}