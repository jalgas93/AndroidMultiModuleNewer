package uz.octo.feature_movies.domain.repository

import uz.octo.feature_movies.domain.model.Popular.DomainPopularItem
import uz.octo.feature_movies.domain.model.People.DomainPeopleItem
import uz.octo.feature_movies.domain.model.category.DominCategoryItem
import uz.octo.feature_movies.domain.model.genre.DomainGenreItem

interface DomainRepository {

    suspend fun getPopular(): List<DomainPopularItem>

    suspend fun getPeoplePopular(): List<DomainPeopleItem>

    suspend fun getGenres():List<DomainGenreItem>
    suspend fun getByCategory(movieId:Int):List<DominCategoryItem>
}