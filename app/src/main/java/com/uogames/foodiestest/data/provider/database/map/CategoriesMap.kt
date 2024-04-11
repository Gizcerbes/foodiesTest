package com.uogames.foodiestest.data.provider.database.map

import com.uogames.foodies.database.entity.CategoryEntity
import com.uogames.foodiestest.domain.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object CategoriesMap {

	fun Category.toEntity() = CategoryEntity(
		id = id,
		name = name
	)

	fun CategoryEntity.toModel() = Category(
		id = id,
		name = name
	)

	fun Flow<List<CategoryEntity>>.mapToModel() = this.map { it.map { item -> item.toModel() } }

}