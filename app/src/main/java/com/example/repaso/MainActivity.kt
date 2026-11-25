package com.example.repaso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.repaso.ui.theme.RepasoTheme

// Importamos nuestro administrador de navegación
import com.example.repaso.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // Contenido gráfico de la aplicación
        setContent {

            // Aplica el tema general
            RepasoTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    // Inicia el sistema de navegación
                    AppNavigation(
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}