package com.ethadien.yaplacaklar.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ethadien.yaplacaklar.data.entity.Work

@Database(entities = [Work::class], version = 1)
abstract class DatabaseTool : RoomDatabase() {

    abstract fun getWorkDao() : WorkDao
}