package uz.octo.feature_movies.data.network

import uz.octo.feature_movies.data.model.PopularMovie.PopularMovie
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import uz.octo.core_network.Constants.API_KEY
import uz.octo.feature_movies.data.model.PeoplePopular.PeoplePopular


interface ApiClient {
    @Headers(
        "accept: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTczZDVhYzEwNzk5YWFiNGQ0MjVhMjgzNDZkYjc4ZSIsInN1YiI6IjYxNjQ0NTA4NTA3MzNjMDA2NDgzZjIyMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.He2bIuySkIllZAmewGYfqypxUNdzMb_Vt6DIlzcfCAc",
    )
    @GET("3/movie/popular")
    suspend fun getPopularMovie(
        @Query("page") page:Int = 1,
        @Query("language") language: String ="ru-RU",
        @Query("api_key") apiKey:String = API_KEY
    ): PopularMovie

    @Headers(
        "accept: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTczZDVhYzEwNzk5YWFiNGQ0MjVhMjgzNDZkYjc4ZSIsInN1YiI6IjYxNjQ0NTA4NTA3MzNjMDA2NDgzZjIyMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.He2bIuySkIllZAmewGYfqypxUNdzMb_Vt6DIlzcfCAc",
    )
    @GET("3/movie/{movie_id}")
    suspend fun getPopularPeople(
        @Query("page") page:Int = 1,
        @Query("language") language: String ="ru-RU",
        @Query("api_key") apiKey:String = API_KEY
    ): PeoplePopular
}