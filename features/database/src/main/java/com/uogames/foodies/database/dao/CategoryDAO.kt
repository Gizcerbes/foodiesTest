package com.uogames.foodies.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uogames.foodies.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDAO {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(vararg entity: CategoryEntity)


	@Query("SELECT * FROM category_table")
	fun getList(): Flow<List<CategoryEntity>>


	@Query("DELETE FROM category_table")
	suspend fun clear()




}