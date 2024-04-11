package com.uogames.retrofitnetwork

import com.google.gson.GsonBuilder
import com.uogames.retrofitnetwork.service.CategoryService
import com.uogames.retrofitnetwork.service.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FoodiesApi(
	private val baseUrl:String = "https://anika1d.github.io/WorkTestServer/"
) {

	private val gson = GsonBuilder().setLenient().create()

	private val retrofit = Retrofit
		.Builder()
		.baseUrl(baseUrl)
		.addConverterFactory(GsonConverterFactory.create(gson))
		.build()


	val category = retrofit.create(CategoryService::class.java)
	val product = retrofit.create(ProductService::class.java)

	fun getImageUrl(imageName: String): String = baseUrl + imageName

}