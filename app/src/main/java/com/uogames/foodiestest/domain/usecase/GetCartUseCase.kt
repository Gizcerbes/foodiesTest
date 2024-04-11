package com.uogames.foodiestest.domain.usecase

import com.uogames.foodiestest.domain.model.FoodItem
import com.uogames.foodiestest.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow

class GetCartUseCase(
	private val database: DatabaseRepository
) {

	fun getCartItems(): Flow<List<FoodItem>> = database.getCartItems()

}