package uz.octo.feature_movies.data.repository

import uz.octo.feature_movies.data.extensions.toCategory
import uz.octo.feature_movies.data.extensions.toGenre
import uz.octo.feature_movies.data.extensions.toPopular
import uz.octo.feature_movies.data.extensions.toPeople
import uz.octo.feature_movies.data.model.category.CategoryItem
import uz.octo.feature_movies.data.network.ApiClient
import uz.octo.feature_movies.domain.model.Popular.DomainPopularItem
import uz.octo.feature_movies.domain.model.People.DomainPeopleItem
import uz.octo.feature_movies.domain.model.category.DominCategoryItem
import uz.octo.feature_movies.domain.model.genre.DomainGenreItem
import uz.octo.feature_movies.domain.repository.DomainRepository
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient
) : DomainRepository {
    override suspend fun getPopular(): List<DomainPopularItem> {
        return apiClient.getPopularMovie().results.map {
            it.toPopular()
        }
    }

    override suspend fun getPeoplePopular(): List<DomainPeopleItem> {
        return apiClient.getPopularPeople().results.map {
            it.toPeople()
        }
    }

    override suspend fun getGenres(): List<DomainGenreItem> {
        return apiClient.getGenres().genres.map {
            it.toGenre()
        }
    }

    override suspend fun getByCategory(movieId:Int): List<DominCategoryItem> {
       return  apiClient.getByCategory(movieId).results.map {
           it.toCategory()
       }
    }

}