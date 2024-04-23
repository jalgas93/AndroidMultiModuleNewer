package uz.octo.feature_movies.domain.repository
import uz.octo.feature_movies.domain.model.Result

interface PopularMovieRepository {

    suspend fun getPopular(): List<Result>
}