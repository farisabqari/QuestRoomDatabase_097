package com.example.pratikum_baru.Data.dao

import androidx.room.Dao
import androidx.room.Index
import androidx.room.Insert
import com.example.pratikum_baru.Data.Entity.Mahasiswa

@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa (
        mahasiswa: Mahasiswa
    )
}