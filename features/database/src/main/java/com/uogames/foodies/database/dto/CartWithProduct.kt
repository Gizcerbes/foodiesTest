package com.uogames.foodies.database.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.uogames.foodies.database.entity.CartEntity
import com.uogames.foodies.database.entity.ProductAndTagEntity
import com.uogames.foodies.database.entity.ProductEntity

data class CartWithProduct(
	@Embedded val cart: CartEntity,
	@Relation(
		parentColumn = "product_id",
		entityColumn = "id"
	)
	val product: ProductEntity,
	@Relation(
		parentColumn = "product_id",
		entityColumn = "product_id"
	)
	val tags: List<ProductAndTagEntity>
)