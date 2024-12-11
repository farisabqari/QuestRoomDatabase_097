package com.example.pratikum_baru

import android.app.Application
import com.example.pratikum_baru.Data.Dependencies.ContainerApp

class KrsApp : Application() {
    lateinit var containerApp: ContainerApp //Fungsinya untuk menyimpan

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this) //Membuat instance
        //instance adalah object yang dibuat dari class
    }
}