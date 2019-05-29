package com.android.one_adapter_example.persistence

import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.one_adapter_example.ExampleApp
import com.android.one_adapter_example.models.MessageModel

@Database(entities = [MessageModel::class], version = 1)
abstract class RoomDB : RoomDatabase() {
    abstract fun messageDao(): MessageDao

    companion object {

        val instance: RoomDB = Room.databaseBuilder(ExampleApp.getInstance(), RoomDB::class.java, "app_database")
                .fallbackToDestructiveMigration()
                .build()
    }
}