package com.uogames.foodiestest.data.provider.network.map

import com.uogames.foodiestest.domain.model.FoodItem
import com.uogames.foodiestest.domain.model.PriceTag
import com.uogames.retrofitnetwork.response.ProductResponse

object ProductMap {

	fun ProductResponse.toModel(currency: String) = FoodItem(
		id = id,
		categoryID = categoryId.toLong(),
		name = name,
		description = description,
		image = image,
		priceCurrent = priceCurrent.toFloat(),
		priceOld = priceOld?.toFloat(),
		measure = measure.toInt(),
		measureUnit = measureUnit,
		currency = currency,
		energyPer100Grams = energyPer100Grams,
		proteinsPer100Grams = proteinsPer100Grams,
		fatsPer100Grams = fatsPer100Grams,
		carbohydratesPer100Grams = carbohydratesPer100Grams,
		tags = tagIds.map { PriceTag.getByID(it) },
		count = 0
	)

	fun List<ProductResponse>.mapToModel(currency: String) = this.map { it.toModel(currency) }


}