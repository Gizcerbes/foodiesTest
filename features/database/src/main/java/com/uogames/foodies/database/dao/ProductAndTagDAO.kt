package com.uogames.foodies.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.uogames.foodies.database.entity.ProductAndTagEntity

@Dao
interface ProductAndTagDAO {

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	suspend fun insert(vararg entity: ProductAndTagEntity)




}