package com.example.pratikum_baru.Data.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pratikum_baru.Data.Entity.Mahasiswa
import com.example.pratikum_baru.Data.dao.MahasiswaDao

import kotlin.concurrent.Volatile
//Mendefinisikan database dg tabel Mahasiswa
@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {

    //Mendefinisikan fungsi untuk mengakses data Mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object{
        @Volatile //Memastikan bhw nilai variabel Instance selalu sama di
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java, //class database
                    "KrsDatabase" //Nama database
                )
                    .build().also { Instance = it }
            })
        }
    }
}