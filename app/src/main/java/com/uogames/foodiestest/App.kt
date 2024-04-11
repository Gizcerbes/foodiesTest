package com.uogames.foodiestest

import android.app.Application
import com.uogames.foodiestest.domain.usecase.UpdateMenuUseCase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {

	@Inject
	lateinit var updateMenuUseCase: UpdateMenuUseCase



}