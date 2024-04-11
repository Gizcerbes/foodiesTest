package com.uogames.foodiestest.data.provider.database

import com.uogames.foodies.database.FoodiesDatabaseProvider
import com.uogames.foodiestest.data.provider.database.map.CartMap.mapToModel
import com.uogames.foodiestest.data.provider.database.map.CartMap.toCartEntity
import com.uogames.foodiestest.data.provider.database.map.CategoriesMap.mapToModel
import com.uogames.foodiestest.data.provider.database.map.CategoriesMap.toEntity
import com.uogames.foodiestest.data.provider.database.map.FoodItemMap.mapToModel
import com.uogames.foodiestest.data.provider.database.map.FoodItemMap.toEntity
import com.uogames.foodiestest.data.provider.database.map.FoodItemMap.toModel
import com.uogames.foodiestest.data.provider.database.map.TagMap.toTagEntity
import com.uogames.foodiestest.domain.model.Category
import com.uogames.foodiestest.domain.model.FoodItem
import com.uogames.foodiestest.domain.model.PriceTag
import com.uogames.foodiestest.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatabaseRepositoryImpl(
	private val database: FoodiesDatabaseProvider,
	private val currency: String
) : DatabaseRepository {

	override suspend fun updateCategories(categories: List<Category>) {
		database.category.insert(*categories.map { it.toEntity() }.toTypedArray())
	}

	override suspend fun updateMenu(items: List<FoodItem>) {
		database.product.insert(*items.map { it.toEntity() }.toTypedArray())
	}

	override suspend fun clear() {
		database.category.clear()
	}

	override fun getMenu(name: String?, categoryID: Int?, tags: List<PriceTag>): Flow<List<FoodItem>> {
		return database.product.getWithRaw(name, categoryID, tags.map { it.id }).mapToModel(currency)
	}

	override fun getCategories(): Flow<List<Category>> {
		return database.category.getList().mapToModel()
	}

	override fun getCartItems(): Flow<List<FoodItem>> {
		return database.cart.getListWithProductFlow().mapToModel(currency)
	}

	override fun getCurrentPrice(): Flow<Float> {
		return database.cart.getCurrentPriceFlow().map { it ?: 0f }
	}

	override suspend fun addToCart(item: FoodItem) {
		database.cart.insert(item.toCartEntity())
	}

	override suspend fun removeFromCart(item: FoodItem) {
		database.cart.delete(item.toCartEntity())
	}

	override suspend fun addTags(pairs: List<Pair<Int, Int>>) {
		database.tag.insert(*pairs.map { it.toTagEntity() }.toTypedArray())
	}

	override fun getItemByID(id: Int): Flow<FoodItem?> {
		return database.product.getById(id).map { it?.toModel(currency) }
	}

}