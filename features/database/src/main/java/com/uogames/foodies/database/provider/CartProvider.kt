package com.uogames.foodies.database.provider

import com.uogames.foodies.database.dao.CartDAO
import com.uogames.foodies.database.entity.CartEntity

class CartProvider(
	private val dao: CartDAO
) {

	suspend fun insert(vararg entity: CartEntity) = dao.insert(*entity)

	suspend fun clear() = dao.clear()

	fun getListFlow() = dao.getListFlow()

	fun getListWithProductFlow() = dao.getListWithProductFlow()

	fun getCurrentPriceFlow() = dao.getCurrentPriceFlow()

	suspend fun delete(entity: CartEntity) = dao.delete(entity)

}