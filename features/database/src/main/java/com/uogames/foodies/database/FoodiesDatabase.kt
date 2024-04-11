package com.uogames.foodies.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uogames.foodies.database.dao.CartDAO
import com.uogames.foodies.database.dao.CategoryDAO
import com.uogames.foodies.database.dao.ProductAndTagDAO
import com.uogames.foodies.database.dao.ProductDAO
import com.uogames.foodies.database.dto.ProductWithTags
import com.uogames.foodies.database.entity.CategoryEntity
import com.uogames.foodies.database.entity.CartEntity
import com.uogames.foodies.database.entity.ProductAndTagEntity
import com.uogames.foodies.database.entity.ProductEntity

typealias DatabaseName = String

@Database(
	entities = [
		CategoryEntity::class,
		ProductEntity::class,
		CartEntity::class,
		ProductAndTagEntity::class
	],
	version = 1
)
abstract class FoodiesDatabase: RoomDatabase() {

	abstract fun categoryDAO(): CategoryDAO

	abstract fun productDAO(): ProductDAO

	abstract fun productAndTagDAO(): ProductAndTagDAO

	abstract fun cartDAO(): CartDAO


	companion object{

		private val MAP_INSTANCE = HashMap<DatabaseName, FoodiesDatabase>()

		fun get(context: Context, databaseName: String): FoodiesDatabase {
			if (MAP_INSTANCE[databaseName] == null) synchronized(this) {
				if (MAP_INSTANCE[databaseName] == null) MAP_INSTANCE[databaseName] = Room
					.databaseBuilder(context, FoodiesDatabase::class.java, databaseName)
					.build()
			}
			return MAP_INSTANCE[databaseName] as FoodiesDatabase
		}


	}




}