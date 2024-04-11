package com.uogames.foodies.database.provider

import com.uogames.foodies.database.dao.CategoryDAO
import com.uogames.foodies.database.entity.CategoryEntity

class CategoryProvider(
	private val dao: CategoryDAO
) {

	suspend fun insert(vararg categoryEntity: CategoryEntity) = dao.insert(*categoryEntity)

	fun getList() = dao.getList()

	suspend fun clear() = dao.clear()

}