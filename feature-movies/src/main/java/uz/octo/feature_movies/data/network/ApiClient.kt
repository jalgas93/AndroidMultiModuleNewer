package uz.octo.feature_movies.data.network

import uz.octo.feature_movies.data.model.Popular.Popular
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import uz.octo.core_network.Constants.API_KEY
import uz.octo.feature_movies.data.model.People.People
import uz.octo.feature_movies.data.model.category.Category
import uz.octo.feature_movies.data.model.details.Details
import uz.octo.feature_movies.data.model.genres.GenreItem


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
    ): Popular

    @Headers(
        "accept: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTczZDVhYzEwNzk5YWFiNGQ0MjVhMjgzNDZkYjc4ZSIsInN1YiI6IjYxNjQ0NTA4NTA3MzNjMDA2NDgzZjIyMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.He2bIuySkIllZAmewGYfqypxUNdzMb_Vt6DIlzcfCAc",
    )
    @GET("3/person/popular")
    suspend fun getPopularPeople(
        @Query("page") page:Int = 1,
        @Query("language") language: String ="ru-RU",
        @Query("api_key") apiKey:String = API_KEY
    ): People
    @Headers(
        "accept: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTczZDVhYzEwNzk5YWFiNGQ0MjVhMjgzNDZkYjc4ZSIsInN1YiI6IjYxNjQ0NTA4NTA3MzNjMDA2NDgzZjIyMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.He2bIuySkIllZAmewGYfqypxUNdzMb_Vt6DIlzcfCAc",
    )
    @GET("3/genre/movie/list")
    suspend fun getGenres(
        @Query("language") language: String ="ru-RU",
        @Query("api_key") apiKey:String = API_KEY
    ): GenreItem
    @Headers(
        "accept: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTczZDVhYzEwNzk5YWFiNGQ0MjVhMjgzNDZkYjc4ZSIsInN1YiI6IjYxNjQ0NTA4NTA3MzNjMDA2NDgzZjIyMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.He2bIuySkIllZAmewGYfqypxUNdzMb_Vt6DIlzcfCAc",
    )
    @GET("3/discover/movie")
    suspend fun getByCategory(
        @Query("with_genres") withGenres:Int,
        @Query("page") page:Int = 1,
        @Query("language") language: String ="ru-RU",
        @Query("api_key") apiKey:String = API_KEY
    ): Category

    @Headers(
        "accept: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTczZDVhYzEwNzk5YWFiNGQ0MjVhMjgzNDZkYjc4ZSIsInN1YiI6IjYxNjQ0NTA4NTA3MzNjMDA2NDgzZjIyMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.He2bIuySkIllZAmewGYfqypxUNdzMb_Vt6DIlzcfCAc",
    )
    @GET("3/movie/{movie_id}")
    suspend fun getDetails(
        @Path("movie_id") movieId:Int,
        @Query("page") page:Int = 1,
        @Query("language") language: String ="ru-RU",
        @Query("api_key") apiKey:String = API_KEY
    ): Details
}