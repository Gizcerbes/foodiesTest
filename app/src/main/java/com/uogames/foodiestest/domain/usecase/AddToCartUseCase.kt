package com.uogames.foodiestest.domain.usecase

import com.uogames.foodiestest.domain.model.FoodItem
import com.uogames.foodiestest.domain.repository.DatabaseRepository

class AddToCartUseCase(
	private val database: DatabaseRepository
) {

	suspend fun addToCart(item: FoodItem) {
		if (item.count > 0)	database.addToCart(item)
		else database.removeFromCart(item)
	}

}