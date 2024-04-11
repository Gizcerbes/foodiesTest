package com.uogames.foodiestest.domain.usecase

import com.uogames.foodiestest.domain.model.FoodItem
import com.uogames.foodiestest.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow

class GetItemByID(
	private val databaseRepository: DatabaseRepository
) {

	fun getItemByID(id: Int): Flow<FoodItem?> {
		return databaseRepository.getItemByID(id)
	}


}