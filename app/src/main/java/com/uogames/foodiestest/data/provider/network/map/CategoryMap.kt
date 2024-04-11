package com.uogames.foodiestest.data.provider.network.map

import com.uogames.foodiestest.domain.model.Category
import com.uogames.retrofitnetwork.response.CategoriesResponse

object CategoryMap {

	fun CategoriesResponse.toModel() = Category(
		id= id,
		name = name
	)


	fun List<CategoriesResponse>.mapToModel() = this.map { it.toModel() }


}