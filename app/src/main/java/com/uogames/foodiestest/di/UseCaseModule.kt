package com.uogames.foodiestest.di

import com.uogames.foodiestest.domain.repository.DatabaseRepository
import com.uogames.foodiestest.domain.repository.NetworkRepository
import com.uogames.foodiestest.domain.usecase.AddToCartUseCase
import com.uogames.foodiestest.domain.usecase.GetCartUseCase
import com.uogames.foodiestest.domain.usecase.GetCategoryListUseCase
import com.uogames.foodiestest.domain.usecase.GetCurrentPriceUseCase
import com.uogames.foodiestest.domain.usecase.GetItemByID
import com.uogames.foodiestest.domain.usecase.GetMenuUseCase
import com.uogames.foodiestest.domain.usecase.UpdateMenuUseCase
import com.uogames.foodiestest.util.Config
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

	@Singleton
	@Provides
	fun provideAddToCartUseCase(
		database: DatabaseRepository
	): AddToCartUseCase = AddToCartUseCase(database)


	@Singleton
	@Provides
	fun provideGetCartUseCase(
		database: DatabaseRepository
	): GetCartUseCase = GetCartUseCase(database)

	@Singleton
	@Provides
	fun provideGetCategoryUseCase(
		database: DatabaseRepository
	): GetCategoryListUseCase = GetCategoryListUseCase(database)

	@Singleton
	@Provides
	fun provideGetMenuUseCase(
		database: DatabaseRepository
	): GetMenuUseCase = GetMenuUseCase(database)

	@Singleton
	@Provides
	fun provideUpdateMenuUseCase(
		database: DatabaseRepository,
		api: NetworkRepository
	): UpdateMenuUseCase = UpdateMenuUseCase(database, api)


	@Singleton
	@Provides
	fun provideGetCurrentPriceUseCase(
		database: DatabaseRepository
	): GetCurrentPriceUseCase = GetCurrentPriceUseCase(database)

	@Singleton
	@Provides
	fun provideGetItemById(
		database: DatabaseRepository
	): GetItemByID = GetItemByID(database)

}