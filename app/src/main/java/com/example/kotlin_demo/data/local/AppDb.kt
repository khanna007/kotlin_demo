package com.example.kotlin_demo.data.local

import android.content.Context
 import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.kotlin_demo.data.CountryModel

@Database(entities = [CountryModel::class], version = 1)
abstract class countryNoteDb : RoomDatabase() {   // to override we use abstract class
    abstract fun countryDow(): CountryDao
    companion object {
        private var instance: countryNoteDb? = null
        @Synchronized
        fun getInstance(ctx: Context): countryNoteDb {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, countryNoteDb::class.java,
                    "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()
            return instance!!
        }
        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }

        fun destroyInstance(){
            instance =  null
        }
    }
}