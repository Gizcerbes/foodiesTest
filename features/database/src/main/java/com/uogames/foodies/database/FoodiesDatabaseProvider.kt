package com.uogames.foodies.database

import android.content.Context
import com.uogames.foodies.database.provider.CartProvider
import com.uogames.foodies.database.provider.CategoryProvider
import com.uogames.foodies.database.provider.ProductProvider
import com.uogames.foodies.database.provider.TagProvider


class FoodiesDatabaseProvider private constructor(
	database: FoodiesDatabase
) {

	companion object{

		private val MAP_INSTANCE = HashMap<DatabaseName, FoodiesDatabaseProvider>()

		fun get(context: Context, databaseName: String): FoodiesDatabaseProvider {
			if (MAP_INSTANCE[databaseName] == null) synchronized(this) {
				if (MAP_INSTANCE[databaseName] == null) MAP_INSTANCE[databaseName] =
					FoodiesDatabaseProvider(FoodiesDatabase.get(context, databaseName))
			}
			return MAP_INSTANCE[databaseName] as FoodiesDatabaseProvider
		}

	}

	val cart = CartProvider(database.cartDAO())
	val category = CategoryProvider(database.categoryDAO())
	val product = ProductProvider(database.productDAO())
	val tag = TagProvider(database.productAndTagDAO())






}