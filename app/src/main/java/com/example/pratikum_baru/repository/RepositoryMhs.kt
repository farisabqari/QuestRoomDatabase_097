package com.example.pratikum_baru.repository


import com.example.pratikum_baru.Data.Entity.Mahasiswa

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa) //interface ini operasinya harus sesuai dengan yang di dao
}