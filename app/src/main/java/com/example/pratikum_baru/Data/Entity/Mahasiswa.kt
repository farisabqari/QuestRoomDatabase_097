package com.example.pratikum_baru.Data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Mahasiswa")
data class Mahasiswa(
    @PrimaryKey
    val nim: String,
    val nama: String,
    val alamat: String,
    val jenisKelamin: String,
    val kelas: String,
    val angkatan: String

)
