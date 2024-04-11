package com.uogames.foodiestest.domain.usecase

import com.uogames.foodiestest.domain.model.Category
import com.uogames.foodiestest.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow

class GetCategoryListUseCase(
	private val database: DatabaseRepository
) {

	fun getCategoryList() : Flow<List<Category>> = database.getCategories()


}