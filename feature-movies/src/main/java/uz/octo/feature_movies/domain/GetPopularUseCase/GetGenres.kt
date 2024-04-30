package uz.octo.feature_movies.domain.GetPopularUseCase

import android.util.Log
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.model.genres.Genre
import uz.octo.feature_movies.domain.repository.PopularMovieRepository
import java.io.IOException
import javax.inject.Inject

class GetGenres @Inject constructor(
    private val repository: PopularMovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Genre>>> = flow {
        try {
            emit(Resource.Loading())
            val genresRepository = repository.getGenres()
            Log.i("Genres", genresRepository.toString())
            emit(Resource.Success(genresRepository))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet "))
        }
    }
}