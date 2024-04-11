package com.uogames.foodiestest.di

import android.content.Context
import com.uogames.foodies.database.FoodiesDatabaseProvider
import com.uogames.foodiestest.data.provider.database.DatabaseRepositoryImpl
import com.uogames.foodiestest.domain.repository.DatabaseRepository
import com.uogames.foodiestest.util.Config
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


	@Singleton
	@Provides
	fun provideDatabaseRepository(
		@ApplicationContext context: Context
	): DatabaseRepository = DatabaseRepositoryImpl(
		database = FoodiesDatabaseProvider.get(context, Config.DATABASE_NAME),
		currency = Config.CURRENCY
	)


}