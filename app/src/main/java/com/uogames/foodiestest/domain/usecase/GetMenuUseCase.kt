package com.uogames.foodiestest.domain.usecase

import com.uogames.foodiestest.domain.model.FoodItem
import com.uogames.foodiestest.domain.model.PriceTag
import com.uogames.foodiestest.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow


class GetMenuUseCase(
	private val databaseRepository: DatabaseRepository
) {

	fun getMenu(
		name: String?,
		categoryID: Int?,
		tags: List<PriceTag>
	): Flow<List<FoodItem>> = databaseRepository.getMenu(name, categoryID, tags)

}