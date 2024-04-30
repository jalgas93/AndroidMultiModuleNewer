package uz.octo.feature_movies.data.repository

import uz.octo.feature_movies.data.extensions.toGenre
import uz.octo.feature_movies.data.extensions.toMovie
import uz.octo.feature_movies.data.extensions.toPeople
import uz.octo.feature_movies.data.network.ApiClient
import uz.octo.feature_movies.domain.model.PopularMovie.Result
import uz.octo.feature_movies.domain.model.PopularPeople.People
import uz.octo.feature_movies.domain.model.genres.Genre
import uz.octo.feature_movies.domain.model.genres.Genres
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

    override suspend fun getPeoplePopular(): List<People> {
        return apiClient.getPopularPeople().results.map {
            it.toPeople()
        }
    }

    override suspend fun getGenres(): List<Genre> {
        return apiClient.getGenres().genres.map {
            it.toGenre()
        }
    }

}