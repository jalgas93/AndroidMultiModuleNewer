package uz.octo.feature_movies.data.repository

import uz.octo.feature_movies.data.extensions.toMovie
import uz.octo.feature_movies.data.network.ApiClient
import uz.octo.feature_movies.domain.model.Result
import uz.octo.feature_movies.domain.repository.PopularMovieRepository
import javax.inject.Inject

class PopularMovieRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient
) : PopularMovieRepository {
    override suspend fun getPopular(): List<Result> {
        return apiClient.getPopularMovie().results.map {
            it.toMovie()
        }
    }

}