package com.uogames.retrofitnetwork

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class GetCategoryTest {

	@Test
	fun getCategoryTest() = runBlocking {
		val api = FoodiesApi()
		val r = api.category.getCategories()
		assertTrue(r.isNotEmpty())
	}

}