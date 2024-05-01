package uz.octo.feature_movies.domain.GetPopularUseCase

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.model.People.DomainPeopleItem
import uz.octo.feature_movies.domain.repository.DomainRepository
import java.io.IOException
import javax.inject.Inject

class GetPeoplePopularUseCase @Inject constructor(
    private val repository: DomainRepository
) {

    operator fun invoke(): Flow<Resource<List<DomainPeopleItem>>> = flow {
        try {
            emit(Resource.Loading())
            val people = repository.getPeoplePopular()
            Log.i("PopularPeople", people.toString())
            emit(Resource.Success(people))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet "))
        }
    }
}