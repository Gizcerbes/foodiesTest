package com.uogames.foodiestest.data.provider.network

import android.util.Log
import com.uogames.foodiestest.data.provider.network.map.CategoryMap.mapToModel
import com.uogames.foodiestest.data.provider.network.map.ProductMap.mapToModel
import com.uogames.foodiestest.domain.model.Category
import com.uogames.foodiestest.domain.model.FoodItem
import com.uogames.foodiestest.domain.repository.NetworkRepository
import com.uogames.retrofitnetwork.FoodiesApi

class NetworkRepositoryImpl(
	private val networkApi: FoodiesApi,
	private val currency: String
): NetworkRepository {

	override suspend fun getMenu(): List<FoodItem> {
		return networkApi.product.getProducts().mapToModel(currency).map {it.copy(image = networkApi.getImageUrl(it.image)) }
	}

	override suspend fun getCategories(): List<Category> {
		return networkApi.category.getCategories().mapToModel()
	}

}