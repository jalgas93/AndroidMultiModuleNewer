package uz.octo.feature_movies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.GetPopularUseCase.CategoryUseCase
import uz.octo.feature_movies.domain.model.category.DominCategoryItem
import uz.octo.feature_movies.presentation.state.PopularListState
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
) : ViewModel() {
    private val _state = MutableLiveData<PopularListState<DominCategoryItem>>()
    val state: LiveData<PopularListState<DominCategoryItem>> = _state
    init {
        getCategory(movieId = 28)
    }
     fun getCategory(movieId:Int) {
        categoryUseCase(movieId =movieId ).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PopularListState(movies = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = PopularListState(error = result.message?: "An unexpected error occurred!")
                }

                is Resource.Loading -> {
                    _state.value = PopularListState(isLoading = true)
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }
}