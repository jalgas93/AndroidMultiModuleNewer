package uz.octo.feature_movies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.GetPopularUseCase.DetailsUseCase
import uz.octo.feature_movies.domain.model.details.DomainDetails
import uz.octo.feature_movies.presentation.state.DetailsState
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private  val detailsUseCase:DetailsUseCase
) :ViewModel(){
    private val _state = MutableLiveData<DetailsState>()
    val state:LiveData<DetailsState> = _state


    init {
        getDetails(movieId =984324 )
    }
    fun getDetails(movieId:Int){
        detailsUseCase(movieId = movieId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DetailsState(details = result.data)
                }

                is Resource.Error -> {
                   // _state.value = DetailsState(error = result.message: "An unexpected error occurred!")
                }

                is Resource.Loading -> {
                    _state.value = DetailsState(isLoading = true)
                }

                else -> {}
            }
        }.launchIn(viewModelScope)

    }
}