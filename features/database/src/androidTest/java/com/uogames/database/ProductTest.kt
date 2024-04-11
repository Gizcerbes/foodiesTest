package com.uogames.database

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.uogames.foodies.database.FoodiesDatabase
import com.uogames.foodies.database.entity.CategoryEntity
import com.uogames.foodies.database.entity.ProductAndTagEntity
import com.uogames.foodies.database.entity.ProductEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ProductTest {

	private lateinit var db: FoodiesDatabase

	private val defProductEntity = ProductEntity(
		id = 1,
		categoryID = 1,
		name = "name",
		description = "description",
		imageName = "image_name",
		priceCurrent = 1f,
		priceOld = null,
		measure = 25,
		measureUnit = "gr",
		energyPer100Grams = 1f,
		proteinsPer100Grams = 2f,
		fatsPer100Grams = 3f,
		carbohydratesPer100Grams = 4f
	)

	@Before
	fun before(){
		val appContext = InstrumentationRegistry.getInstrumentation().targetContext
		db = FoodiesDatabase.get(appContext, "db_name")
	}

	@After
	@Throws(IOException::class)
	fun after(){
		db.close()
	}

	@Test
	@Throws(Exception::class)
	fun getWithRawTest() = runBlocking {

		db.categoryDAO().insert(CategoryEntity(1,"name"))

		db.productDAO().insert(defProductEntity.copy(id = 1, name = "ab"))
		db.productDAO().insert(defProductEntity.copy(id = 2, name = "a"))
		db.productDAO().insert(defProductEntity.copy(id = 3, name = "abc"))
		db.productDAO().insert(defProductEntity.copy(id = 4, name = "abcd"))
		db.productDAO().insert(defProductEntity.copy(id = 5, name = "abcde"))

		db.productAndTagDAO().insert(ProductAndTagEntity(1, 1))
		db.productAndTagDAO().insert(ProductAndTagEntity(2, 2))
		db.productAndTagDAO().insert(ProductAndTagEntity(1, 2))


		assertEquals(db.productDAO().getWithRaw().first().size, 5)
		assertEquals(db.productDAO().getWithRaw(name = "ab").first().size, 4)
		assertEquals(db.productDAO().getWithRaw(name = "abc").first().size, 3)
		assertEquals(db.productDAO().getWithRaw(name = "b").first().size, 4)
		assertEquals(db.productDAO().getWithRaw(name = "e").first().size, 1)
		assertEquals(db.productDAO().getWithRaw(name = "f").first().size, 0)
		assertEquals(db.productDAO().getWithRaw(categoryID = 1).first().size, 5)
		assertEquals(db.productDAO().getWithRaw(categoryID = 2).first().size, 0)
		assertEquals(db.productDAO().getWithRaw(tags = listOf(1)).first().size, 1)
		assertEquals(db.productDAO().getWithRaw(tags = listOf(2)).first().size, 2)
		assertEquals(db.productDAO().getWithRaw(tags = listOf(1, 2)).first().size, 2)
		assertEquals(db.productDAO().getWithRaw(tags = listOf(1, 2, 3)).first().size, 2)
		assertEquals(db.productDAO().getWithRaw(tags = listOf(3)).first().size, 0)
		assertEquals(db.productDAO().getWithRaw(name = "b", tags = listOf(1, 2)).first().size, 1)
		assertEquals(db.productDAO().getWithRaw(name = "c", tags = listOf(1, 2)).first().size, 0)
		assertEquals(db.productDAO().getWithRaw(name = "a", tags = listOf(1, 2)).first().size, 2)

		val sortedList = db.productDAO().getWithRaw(name = "a").first()
		assertEquals(sortedList[0].name.length, 1)
		assertEquals(sortedList[1].name.length, 2)
		assertEquals(sortedList[2].name.length, 3)
		assertEquals(sortedList[3].name.length, 4)
		assertEquals(sortedList[4].name.length, 5)

	}



}