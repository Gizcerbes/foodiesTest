package com.uogames.foodiestest.domain.usecase

import com.uogames.foodiestest.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow


class GetCurrentPriceUseCase(
	private val databaseRepository: DatabaseRepository
) {

	fun getCurrentPrice() : Flow<Float> {
		return databaseRepository.getCurrentPrice()
	}

}