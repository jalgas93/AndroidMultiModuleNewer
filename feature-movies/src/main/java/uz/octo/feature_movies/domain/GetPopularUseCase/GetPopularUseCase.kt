package uz.octo.feature_movies.domain.GetPopularUseCase
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.repository.PopularMovieRepository
import java.io.IOException
import javax.inject.Inject
import uz.octo.feature_movies.domain.model.Result

class GetPopularUseCase @Inject constructor(
    private val repository: PopularMovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Result>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = repository.getPopular()
            Log.i("jalgas", movies.toString())
            emit(Resource.Success(movies))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet "))
        }
    }
}