package com.miempresa.semana09_unocc.repository

import com.miempresa.semana09_unocc.data.dao.InstructorDao
import com.miempresa.semana09_unocc.data.model.Instructor
import kotlinx.coroutines.flow.Flow

class InstructorRepository(private val dao: InstructorDao){
    suspend fun insert(instructor: Instructor): Long {
        return dao.insert(instructor)
    }
    fun getAll(): Flow<List<Instructor>> = dao.getAllInstructors()
}