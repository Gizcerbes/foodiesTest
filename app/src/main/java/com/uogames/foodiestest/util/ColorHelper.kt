package com.uogames.foodiestest.util

object ColorHelper {

	data class ARGB(val a: Int, val r: Int, val g: Int, val b: Int) {

		fun toInt(): Int = a.shl(24)
			.xor(r.shl(16))
			.xor(g.shl(8))
			.xor(b)


	}

	fun transformARGB(color: Int): ARGB {
		val long = color.toLong()
		return ARGB(
			a = long.and(4278190080L).shr(24).toInt(),
			r = long.and(16711680).shr(16).toInt(),
			g = long.and(65280).shr(8).toInt(),
			b = long.and(255).toInt()
		)
	}

	fun isLight(color: Int): Boolean {
		val argb = transformARGB(color)
		return (argb.r * 0.2126 + argb.g * 0.7152 + argb.b * 0.0722) > 127
	}

	fun multiply(color: Int, cof: Float): Int {
		val argb = transformARGB(color)
		var r = argb.r * cof
		var g = argb.g * cof
		var b = argb.b * cof
		if (r > 255) r = 255f
		if (g > 255) g = 255f
		if (b > 255) b = 255f
		return argb.a.shl(24)
			.xor(r.toInt().shl(16))
			.xor(g.toInt().shl(8))
			.xor(b.toInt())
	}

	fun gradient(startColor: Int, endColor: Int, progress: Float): Int {
		val start = transformARGB(startColor)
		val end = transformARGB(endColor)
		val argb = ARGB(
			r = (start.r + (end.r - start.r) * progress).toInt(),
			g = (start.g + (end.g - start.g) * progress).toInt(),
			b = (start.b + (end.b - start.b) * progress).toInt(),
			a = (start.a + (end.a - start.a) * progress).toInt()
		)
		return argb.toInt()
	}

}