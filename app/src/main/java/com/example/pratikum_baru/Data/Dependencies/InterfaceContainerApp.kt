package com.example.pratikum_baru.Data.Dependencies

import android.content.Context
import com.example.pratikum_baru.Data.database.KrsDatabase
import com.example.pratikum_baru.repository.LocalRepositoryMhs
import com.example.pratikum_baru.repository.RepositoryMhs


interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs
}
//semua repository harus dimasukkan kedalam interface ini

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}