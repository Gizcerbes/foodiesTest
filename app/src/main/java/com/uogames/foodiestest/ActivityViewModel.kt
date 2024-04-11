package com.uogames.foodiestest

import androidx.compose.runtime.mutableFloatStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uogames.foodiestest.domain.repository.DatabaseRepository
import com.uogames.foodiestest.domain.usecase.UpdateMenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
	private val updateMenuUseCase: UpdateMenuUseCase,
	private val databaseRepository: DatabaseRepository
): ViewModel() {


	val splashProgress = mutableFloatStateOf(0f)

	val updateState = updateMenuUseCase.updateState

	init {
		update()
	}

	fun update() {
		viewModelScope.launch(Dispatchers.IO) {
			delay(100)
			updateMenuUseCase.update()
		}
	}

	suspend fun clear(){
		databaseRepository.clear()
	}


}