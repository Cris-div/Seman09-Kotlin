package com.miempresa.semana09_unocc.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//modelo que representa la base de datos

@Entity(tableName = "instructor")
data class Instructor(
    @PrimaryKey(autoGenerate = true)
    val codigo: Int =0,
    val apellido: String,
    val nombre: String,
    val horasDictadas: Int,
    val pagoPorHora: Double
)