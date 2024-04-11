package com.uogames.foodiestest.di

import com.uogames.foodiestest.data.provider.network.NetworkRepositoryImpl
import com.uogames.foodiestest.domain.repository.NetworkRepository
import com.uogames.foodiestest.util.Config
import com.uogames.retrofitnetwork.FoodiesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	@Singleton
	@Provides
	fun provideNetworkRepository(): NetworkRepository = NetworkRepositoryImpl(
		networkApi = FoodiesApi(baseUrl = Config.BASE_URL),
		currency = Config.CURRENCY
	)


}