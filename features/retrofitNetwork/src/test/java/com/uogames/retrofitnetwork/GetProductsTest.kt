package com.uogames.retrofitnetwork

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class GetProductsTest {


	@Test
	fun getProductsTest() = runBlocking{
		val api = FoodiesApi()
		val r = api.product.getProducts()
		assertTrue(r.isNotEmpty())
	}

}