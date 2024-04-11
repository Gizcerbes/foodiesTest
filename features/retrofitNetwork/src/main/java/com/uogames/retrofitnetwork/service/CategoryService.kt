package com.uogames.retrofitnetwork.service

import com.uogames.retrofitnetwork.response.CategoriesResponse
import retrofit2.http.GET

interface CategoryService {


	@GET("Categories.json")
	suspend fun getCategories(): List<CategoriesResponse>

}