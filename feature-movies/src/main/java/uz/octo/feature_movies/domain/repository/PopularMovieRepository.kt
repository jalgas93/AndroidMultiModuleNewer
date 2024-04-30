package uz.octo.feature_movies.domain.repository

import uz.octo.feature_movies.domain.model.PopularMovie.Result
import uz.octo.feature_movies.domain.model.PopularPeople.People
import uz.octo.feature_movies.domain.model.genres.Genre
import uz.octo.feature_movies.domain.model.genres.Genres

interface PopularMovieRepository {

    suspend fun getPopular(): List<Result>

    suspend fun getPeoplePopular(): List<People>

    suspend fun getGenres():List<Genre>
}