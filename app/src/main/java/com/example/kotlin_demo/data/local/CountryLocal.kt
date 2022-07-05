package com.example.kotlin_demo.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
class CountryLocal(
    @field:PrimaryKey(autoGenerate = true) val id: Long=0,
    @field:ColumnInfo(name = "name") val name: String?,
    @field:ColumnInfo(name = "capital") val capital: String?,
    @field:ColumnInfo(name = "flagPNG") val flagPNG: String?,
)