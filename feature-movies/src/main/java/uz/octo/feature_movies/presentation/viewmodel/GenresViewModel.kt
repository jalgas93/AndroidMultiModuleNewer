package uz.octo.feature_movies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.GetPopularUseCase.GetGenres
import uz.octo.feature_movies.presentation.state.GenresListState
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(
    private val getGenresUseCase: GetGenres
) : ViewModel() {
    private val _state = MutableLiveData<GenresListState>()
    val state: LiveData<GenresListState> = _state

    init {
        getGenres()
    }

    private fun getGenres() {
        getGenresUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = GenresListState(genres = result.data ?: emptyList())
                }

                is Resource.Loading -> {
                    _state.value = GenresListState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value =
                        GenresListState(error = result.message ?: "An unexpected error occurred!")
                }
            }
        }.launchIn(viewModelScope)
    }
}