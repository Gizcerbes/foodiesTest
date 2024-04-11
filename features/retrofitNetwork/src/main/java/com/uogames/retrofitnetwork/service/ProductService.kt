package com.uogames.retrofitnetwork.service

import com.uogames.retrofitnetwork.response.ProductResponse
import retrofit2.http.GET

interface ProductService {


	@GET("Products.json")
	suspend fun getProducts(): List<ProductResponse>



}