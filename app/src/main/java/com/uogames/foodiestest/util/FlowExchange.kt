package com.uogames.foodiestest.util

import kotlinx.coroutines.flow.MutableStateFlow


fun MutableStateFlow<Boolean>.setOpposite() {
	value = !value
}