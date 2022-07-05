package com.example.kotlin_demo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    fun getAlphabetizedWords(): List<CountryLocal>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: CountryLocal)

    @Query("DELETE FROM country")
    suspend fun deleteAll()


}