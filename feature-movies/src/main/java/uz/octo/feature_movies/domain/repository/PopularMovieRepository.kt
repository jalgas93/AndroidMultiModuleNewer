package uz.octo.feature_movies.domain.repository

import uz.octo.feature_movies.domain.model.PopularMovie.Result
import uz.octo.feature_movies.domain.model.PopularPeople.People

interface PopularMovieRepository {

    suspend fun getPopular(): List<Result>

    suspend fun getPeoplePopular(): List<People>
}