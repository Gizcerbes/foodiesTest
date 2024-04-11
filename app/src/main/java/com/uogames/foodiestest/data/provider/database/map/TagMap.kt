package com.uogames.foodiestest.data.provider.database.map

import com.uogames.foodies.database.entity.ProductAndTagEntity

object TagMap {


	fun Pair<Int, Int>.toTagEntity() = ProductAndTagEntity(
		productID = first,
		tagID = second
	)

}