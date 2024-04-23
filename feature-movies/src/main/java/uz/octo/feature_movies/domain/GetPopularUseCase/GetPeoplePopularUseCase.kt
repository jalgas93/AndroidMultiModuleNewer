package uz.octo.feature_movies.domain.GetPopularUseCase

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.octo.core_network.Resource
import uz.octo.feature_movies.domain.model.PopularPeople.People
import uz.octo.feature_movies.domain.repository.PopularMovieRepository
import java.io.IOException
import javax.inject.Inject

class GetPeoplePopularUseCase @Inject constructor(
    private val repository: PopularMovieRepository
) {

    operator fun invoke(): Flow<Resource<List<People>>> = flow {
        try {
            emit(Resource.Loading())
            val peoplePopular = repository.getPeoplePopular()
            Log.i("PopularPeople", peoplePopular.toString())
            emit(Resource.Success(peoplePopular))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet "))
        }
    }
}