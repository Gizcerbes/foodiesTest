package com.uogames.foodies.database.provider

import com.uogames.foodies.database.dao.ProductAndTagDAO
import com.uogames.foodies.database.entity.ProductAndTagEntity

class TagProvider(
	private val dao: ProductAndTagDAO
) {

	suspend fun insert(vararg entity: ProductAndTagEntity) = dao.insert(*entity)

}