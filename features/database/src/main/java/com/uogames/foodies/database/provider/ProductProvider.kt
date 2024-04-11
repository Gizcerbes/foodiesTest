package com.uogames.foodies.database.provider

import androidx.room.Query
import androidx.sqlite.db.SupportSQLiteQueryBuilder
import com.uogames.foodies.database.dao.ProductDAO
import com.uogames.foodies.database.entity.ProductEntity

class ProductProvider(
	private val dao: ProductDAO
) {

	suspend fun insert(vararg entity: ProductEntity) = dao.insert(*entity)


	fun getWithRaw(
		name: String? = null,
		categoryID: Int? = null,
		tags: List<Int> = emptyList()
	) = dao.getWithRaw(name, categoryID, tags)

	fun getById(id: Int) = dao.getByID(id)

}