package com.miempresa.semana09_unocc.presentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miempresa.semana09_unocc.presentacion.screens.InstructorFormScreen
import com.miempresa.semana09_unocc.presentacion.screens.InstructorListScreen
import com.miempresa.semana09_unocc.viewmodel.InstructorViewModel


class MainActivity : ComponentActivity() {
    private val viewModel: InstructorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        InstructorFormScreen(onSave = {apellido, nombre, horas, pagoHora ->
                            viewModel.insterInstructor(apellido,nombre,horas,pagoHora)
                        })
                        InstructorListScreen(viewModel=viewModel)
                    }
                }
            }
        }
    }
}


