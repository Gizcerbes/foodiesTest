package com.uogames.foodiestest.data.provider.database.map

import com.uogames.foodies.database.dto.ProductWithCurtCountAndTags
import com.uogames.foodies.database.entity.ProductEntity
import com.uogames.foodiestest.domain.model.FoodItem
import com.uogames.foodiestest.domain.model.PriceTag
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object FoodItemMap {


	fun FoodItem.toEntity() = ProductEntity(
		id = id,
		categoryID = categoryID.toInt(),
		name = name,
		description = description,
		imageName = image,
		priceCurrent = priceCurrent.toFloat(),
		priceOld = priceOld?.toFloat(),
		measure = measure,
		measureUnit = measureUnit,
		energyPer100Grams = energyPer100Grams.toFloat(),
		proteinsPer100Grams = proteinsPer100Grams.toFloat(),
		fatsPer100Grams = fatsPer100Grams.toFloat(),
		carbohydratesPer100Grams = carbohydratesPer100Grams.toFloat(),
	)

	fun ProductWithCurtCountAndTags.toModel(currency: String) = FoodItem(
		id = id,
		categoryID = categoryID.toLong(),
		name = name,
		description = description,
		image = imageName,
		priceCurrent = priceCurrent,
		priceOld = priceOld,
		measure = measure,
		measureUnit = measureUnit,
		currency = currency,
		energyPer100Grams = energyPer100Grams,
		proteinsPer100Grams = proteinsPer100Grams,
		fatsPer100Grams = fatsPer100Grams,
		carbohydratesPer100Grams = carbohydratesPer100Grams,
		tags = tags.map { PriceTag.getByID(it.tagID) },
		count = cartCunt
	)


	fun Flow<List<ProductWithCurtCountAndTags>>.mapToModel(currency: String) = this.map { it.map { item -> item.toModel(currency) } }


}