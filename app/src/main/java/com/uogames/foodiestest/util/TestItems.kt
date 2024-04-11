package com.uogames.foodiestest.util

import com.uogames.foodiestest.domain.model.Category
import com.uogames.foodiestest.domain.model.Filter
import com.uogames.foodiestest.domain.model.FoodItem
import com.uogames.foodiestest.domain.model.PriceTag

object TestItems {

	val foodItem = FoodItem(
		id = 0,
		categoryID = 0,
		name = "Name",
		description = "Description",
		image = "",
		priceCurrent = 150,
		priceOld = null,
		measure = 300,
		measureUnit = "gr",
		currency = "$",
		energyPer100Grams = 307.8f,
		proteinsPer100Grams = 6.1f,
		fatsPer100Grams = 11.4f,
		carbohydratesPer100Grams = 45.1f,
		tags = listOf(PriceTag.SPICY)
	)

	val foodItem2 = foodItem.copy(
		id = 1,
		tags = listOf(PriceTag.VEGETARIAN),
		priceOld = 150
	)

	val foodItem3 = foodItem2.copy(
		id = 2,
		tags = listOf(PriceTag.VEGETARIAN, PriceTag.SPICY, PriceTag.DISCOUNT)
	)

	val categories = listOf(
		Category(1, "Роллы"),
		Category(2, "Суши"),
		Category(3, "Наборы"),
		Category(4, "Горячие блюда"),
	)

	val filters = listOf(
		Filter("Vegetarian", false),
		Filter("Spicy", false),
		Filter("Discount", false)
	)

	val dishes = listOf(
		foodItem,
		foodItem2,
		foodItem3
	)
}