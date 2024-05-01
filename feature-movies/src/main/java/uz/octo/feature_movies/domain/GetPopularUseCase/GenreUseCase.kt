package uz.octo.feature_movies.domain.GetPopularUseCase

import android.util.Log
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.model.genre.DomainGenreItem
import uz.octo.feature_movies.domain.repository.DomainRepository
import java.io.IOException
import javax.inject.Inject

class GenreUseCase @Inject constructor(
    private val repository: DomainRepository
) {
    operator fun invoke(): Flow<Resource<List<DomainGenreItem>>> = flow {
        try {
            emit(Resource.Loading())
            val genre = repository.getGenres()
            Log.i("Genres", genre.toString())
            emit(Resource.Success(genre))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet "))
        }
    }
}