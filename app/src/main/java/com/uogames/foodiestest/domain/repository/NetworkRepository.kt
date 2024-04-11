package com.uogames.foodiestest.domain.repository

import com.uogames.foodiestest.domain.model.Category
import com.uogames.foodiestest.domain.model.FoodItem

interface NetworkRepository {

	suspend fun getMenu(): List<FoodItem>

	suspend fun getCategories(): List<Category>



}