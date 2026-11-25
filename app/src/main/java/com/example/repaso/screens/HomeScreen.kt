package com.example.repaso.screens

import androidx.compose.foundation.layout.*

// Permite crear listas desplazables
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Permite observar estados del ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.example.repaso.viewmodel.PlanViewModel

/**
 * Pantalla principal de la aplicación.
 *
 * Muestra los planes obtenidos desde el backend.
 *
 * @param viewModel Administra los datos.
 * @param onCrearPlan Evento de navegación.
 */
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: PlanViewModel,
    onCrearPlan: () -> Unit = {}
) {

    // Observamos los estados del ViewModel
    val planes by viewModel.planes
        .collectAsStateWithLifecycle()

    val cargando by viewModel.cargando
        .collectAsStateWithLifecycle()

    val error by viewModel.error
        .collectAsStateWithLifecycle()


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        // Título principal
        Text(
            text = "Plan Familiar de Ahorro",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón para navegar al formulario
        Button(
            onClick = onCrearPlan,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF079158)
            )
        ) {
            Text("Crear plan")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Planes de ahorro",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))


        // ==============================
        // ESTADOS DE LA INTERFAZ
        // ==============================

        if (cargando) {

            // Indicador mientras responde el servidor
            CircularProgressIndicator()

        } else if (error != null) {

            // Mostramos el error de comunicación
            Text(
                text = error ?: "",
                color = Color.Red
            )

            Button(
                onClick = {
                    viewModel.obtenerPlanes()
                }
            ) {
                Text("Reintentar")
            }

        } else if (planes.isEmpty()) {

            // No existen registros en SQLite
            Text("No hay planes registrados")

        } else {

            // Lista desplazable de planes
            LazyColumn(
                verticalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                // Recorremos los planes obtenidos
                items(
                    items = planes,
                    key = { it.id }
                ) { plan ->

                    // Una tarjeta por cada plan
                    OutlinedCard(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = plan.name,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(plan.motive ?: "Sin motivo")

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "$${plan.targetAmount}",
                                fontSize = 22.sp
                            )

                            Text("${plan.months} meses")
                        }
                    }
                }
            }
        }
    }
}