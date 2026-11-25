package com.example.repaso.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Permite obtener una instancia del ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.repaso.viewmodel.PlanViewModel
import com.example.repaso.screens.HomeScreen
import com.example.repaso.screens.CrearPlanScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    // Controlador de navegación
    val navController = rememberNavController()

    // ViewModel compartido entre las pantallas
    val planViewModel: PlanViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {

        composable("home") {

            HomeScreen(

                // Enviamos el ViewModel a la pantalla
                viewModel = planViewModel,

                onCrearPlan = {
                    navController.navigate("crearPlan")
                }
            )
        }

        composable("crearPlan") {

            CrearPlanScreen()

        }
    }
}