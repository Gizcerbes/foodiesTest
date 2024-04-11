package com.uogames.foodiestest.domain.usecase

import com.uogames.foodiestest.domain.model.LoadState
import com.uogames.foodiestest.domain.repository.DatabaseRepository
import com.uogames.foodiestest.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UpdateMenuUseCase(
	private val database: DatabaseRepository,
	private val network: NetworkRepository
) {

	private val _updateState = MutableStateFlow<LoadState>(LoadState.Loading)
	val updateState = _updateState.asStateFlow()

	suspend fun update() = try {
		_updateState.value = LoadState.Loading
		val categories = network.getCategories()
		val menu = network.getMenu()
		database.clear()
		database.updateCategories(categories)
		database.updateMenu(menu)
		menu.forEach {item ->
			val r = item.tags.map { tag -> item.id to tag.id }
			database.addTags(r)
		}
		_updateState.value = LoadState.Loaded
	} catch (e: Exception) {
		_updateState.value = LoadState.Error(e.message.orEmpty())
	}


}