package com.uogames.foodiestest.data.provider.database.map

import com.uogames.foodies.database.dto.CartWithProduct
import com.uogames.foodies.database.entity.CartEntity
import com.uogames.foodiestest.domain.model.FoodItem
import com.uogames.foodiestest.domain.model.PriceTag
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object CartMap {

	fun CartWithProduct.toModel(currency: String) = FoodItem(
		id = product.id,
		categoryID = product.categoryID.toLong(),
		name = product.name,
		description = product.description,
		image = product.imageName,
		priceCurrent = product.priceCurrent,
		priceOld = product.priceOld,
		measure = product.measure,
		measureUnit = product.measureUnit,
		currency = currency,
		energyPer100Grams = product.energyPer100Grams,
		proteinsPer100Grams = product.proteinsPer100Grams,
		fatsPer100Grams = product.fatsPer100Grams,
		carbohydratesPer100Grams = product.carbohydratesPer100Grams,
		tags = tags.map { PriceTag.getByID(it.tagID) },
		count = cart.count
	)

	fun List<CartWithProduct>.toModelMap(currency: String) = this.map { it.toModel(currency) }

	fun Flow<List<CartWithProduct>>.mapToModel(currency: String) = this.map { it.toModelMap(currency) }

	fun FoodItem.toCartEntity() = CartEntity(
		productID = id,
		count = count
	)

}