package uz.octo.feature_movies.domain.GetPopularUseCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.model.Popular.DomainPopularItem
import uz.octo.feature_movies.domain.model.category.DominCategoryItem
import uz.octo.feature_movies.domain.repository.DomainRepository
import java.io.IOException
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val repository: DomainRepository
) {
    operator fun invoke(movieId: Int): Flow<Resource<List<DominCategoryItem>>> = flow {
        try {
            emit(Resource.Loading())
            val category = repository.getByCategory(movieId = movieId)
            emit(Resource.Success(category))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet "))
        }
    }
}