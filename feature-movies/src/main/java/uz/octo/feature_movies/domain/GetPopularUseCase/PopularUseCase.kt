package uz.octo.feature_movies.domain.GetPopularUseCase
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.repository.DomainRepository
import java.io.IOException
import javax.inject.Inject
import uz.octo.feature_movies.domain.model.Popular.DomainPopularItem

class PopularUseCase @Inject constructor(
    private val repository: DomainRepository
) {
    operator fun invoke(): Flow<Resource<List<DomainPopularItem>>> = flow {
        try {
            emit(Resource.Loading())
            val popular = repository.getPopular()
            Log.i("jalgas", popular.toString())
            emit(Resource.Success(popular))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet "))
        }
    }
}