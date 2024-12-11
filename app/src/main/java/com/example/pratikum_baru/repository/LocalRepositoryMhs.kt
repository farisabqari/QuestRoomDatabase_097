package com.example.pratikum_baru.repository

import com.example.pratikum_baru.Data.Entity.Mahasiswa
import com.example.pratikum_baru.Data.dao.MahasiswaDao


class LocalRepositoryMhs (
    private val mahasiswaDao: MahasiswaDao
) : RepositoryMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }
}