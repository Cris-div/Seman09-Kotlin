package com.miempresa.semana09_unocc.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.miempresa.semana09_unocc.data.db.AppDatabase
import com.miempresa.semana09_unocc.data.model.Instructor
import com.miempresa.semana09_unocc.repository.InstructorRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class InstructorViewModel (application: Application): AndroidViewModel(application){
    private val repository: InstructorRepository

    val instructors: StateFlow<List<Instructor>>

    init {
        val dao = AppDatabase.getInstance(application).instructorDao()
        repository= InstructorRepository(dao)

        instructors= repository.getAll()
            .map { it }
            .stateIn(viewModelScope, SharingStarted.Lazily , emptyList())
    }

    fun insterInstructor(apellido: String , nombre: String , horas: Int , pagoHora: Double){
        val inst = Instructor(
            apellido = apellido,
            nombre = nombre,
            horasDictadas= horas,
            pagoPorHora= pagoHora
        )

        viewModelScope.launch {
            repository.insert(inst)
        }
    }
}