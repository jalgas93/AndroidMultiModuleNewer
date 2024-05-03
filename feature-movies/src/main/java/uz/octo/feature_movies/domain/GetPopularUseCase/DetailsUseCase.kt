package uz.octo.feature_movies.domain.GetPopularUseCase


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.model.details.DomainDetails
import uz.octo.feature_movies.domain.repository.DomainRepository
import java.io.IOException
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val repository: DomainRepository
) {

    operator  fun invoke(movieId:Int):Flow<Resource<DomainDetails>> = flow {
        try {
            emit(Resource.Loading())
            val details = repository.getDetails(movieId)
            emit(Resource.Success(details))
        }catch (e:IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet "))
        }
    }
}