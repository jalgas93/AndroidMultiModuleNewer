package uz.octo.feature_movies.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import uz.octo.feature_movies.data.network.ApiClient
import uz.octo.feature_movies.data.repository.DataRepositoryImpl
import uz.octo.feature_movies.domain.repository.DomainRepository
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
    fun provideCoinRepository(api: ApiClient): DomainRepository {
        return DataRepositoryImpl(api);
    }
}