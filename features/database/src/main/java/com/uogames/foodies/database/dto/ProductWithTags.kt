package com.uogames.foodies.database.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.uogames.foodies.database.entity.ProductAndTagEntity
import com.uogames.foodies.database.entity.ProductEntity


data class ProductWithTags(
	@Embedded
	val product: ProductEntity,
	@Relation(
		parentColumn = "id",
		entityColumn = "product_id",
	)
	val tags: List<ProductAndTagEntity>
)