package uz.octo.feature_movies.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.octo.feature_movies.data.network.ApiClient
import uz.octo.feature_movies.data.repository.PopularMovieRepositoryImpl
import uz.octo.feature_movies.domain.repository.PopularMovieRepository
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    internal fun providesService(retrofit: Retrofit): ApiClient =
        retrofit.create(ApiClient::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: ApiClient): PopularMovieRepository {
        return PopularMovieRepositoryImpl(api);
    }
}