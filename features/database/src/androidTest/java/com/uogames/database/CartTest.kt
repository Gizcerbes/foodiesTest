package com.uogames.database

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.uogames.foodies.database.FoodiesDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CartTest {

	private lateinit var db: FoodiesDatabase

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
	fun curtTest() = runBlocking{
		val f = db.cartDAO().getCurrentPriceFlow().first()
		Assert.assertTrue(f == null)
	}


}