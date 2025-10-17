package com.miempresa.semana09_unocc.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.miempresa.semana09_unocc.data.dao.InstructorDao
import com.miempresa.semana09_unocc.data.model.Instructor

@Database(entities = [Instructor::class], version = 1 , exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun instructorDao(): InstructorDao

    companion object{
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: buildDatabase(context).also {INSTANCE= it }
            }

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "semanacrud_basico.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}