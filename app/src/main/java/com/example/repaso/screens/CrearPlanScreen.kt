package com.example.repaso.screens

// Importaciones para organizar los componentes gráficos
import androidx.compose.foundation.layout.*

// Permite configurar el teclado del dispositivo
import androidx.compose.foundation.text.KeyboardOptions

// Componentes gráficos de Material Design 3
import androidx.compose.material3.*

// Permite utilizar Composable, remember y mutableStateOf
import androidx.compose.runtime.*

// Permite modificar las propiedades de los componentes
import androidx.compose.ui.Modifier

// Permite establecer colores personalizados
import androidx.compose.ui.graphics.Color

// Permite modificar el grosor de las letras
import androidx.compose.ui.text.font.FontWeight

// Permite seleccionar el tipo de teclado
import androidx.compose.ui.text.input.KeyboardType

// Unidades de medida para componentes y textos
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Permite visualizar la pantalla sin ejecutar la aplicación
import androidx.compose.ui.tooling.preview.Preview


/**
 * Pantalla encargada de mostrar el formulario
 * para crear un nuevo plan de ahorro familiar.
 *
 * @param modifier Permite recibir modificaciones
 * externas desde MainActivity u otro componente.
 */
@Composable
fun CrearPlanScreen(modifier: Modifier = Modifier) {

    // ==============================
    // ESTADOS DE LA PANTALLA
    // ==============================

    // remember conserva el valor entre recomposiciones.
    // mutableStateOf permite que Compose observe sus cambios.
    // by permite acceder al valor sin utilizar .value.

    var motivo by remember { mutableStateOf("") }
    var meta by remember { mutableStateOf("") }
    var meses by remember { mutableStateOf("") }
    var miembros by remember { mutableStateOf("") }


    // ==============================
    // CONTENEDOR PRINCIPAL
    // ==============================

    // Column organiza los componentes verticalmente.
    Column(
        modifier = modifier
            .fillMaxSize() // Ocupa todo el espacio disponible
            .padding(20.dp) // Espaciado interior
    ) {

        // ==============================
        // TÍTULO DE LA PANTALLA
        // ==============================

        Text(
            text = "Crear plan",
            fontSize = 28.sp, // Tamaño del texto
            fontWeight = FontWeight.Bold // Texto en negrita
        )

        // Separación vertical entre componentes
        Spacer(modifier = Modifier.height(24.dp))


        // ==============================
        // CAMPO MOTIVO
        // ==============================

        Text("Motivo")

        OutlinedTextField(

            // Valor actual que muestra el campo
            value = motivo,

            // Actualiza la variable cuando el usuario escribe.
            // it representa el nuevo texto ingresado.
            onValueChange = { motivo = it },

            // Ocupa todo el ancho disponible
            modifier = Modifier.fillMaxWidth(),

            // Limita el campo a una sola línea
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))


        // ==============================
        // CAMPO META DE AHORRO
        // ==============================

        Text("Meta")

        OutlinedTextField(
            value = meta,
            onValueChange = { meta = it },
            modifier = Modifier.fillMaxWidth(),

            // Solicita un teclado numérico al dispositivo.
            // No impide por sí solo ingresar caracteres inválidos.
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),

            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))


        // ==============================
        // CAMPO MESES
        // ==============================

        Text("Meses")

        OutlinedTextField(

            // Almacena la duración del plan de ahorro
            value = meses,

            // Actualiza la duración ingresada
            onValueChange = { meses = it },

            modifier = Modifier.fillMaxWidth(),

            // Solicita un teclado numérico
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),

            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))


        // ==============================
        // CAMPO MIEMBROS
        // ==============================

        Text("Miembros")

        OutlinedTextField(

            // Almacena provisionalmente los nombres
            // de los miembros como una cadena de texto.
            value = miembros,

            onValueChange = { miembros = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))


        // ==============================
        // BOTÓN CREAR PLAN
        // ==============================

        Button(

            // Evento ejecutado al presionar el botón.
            // Posteriormente llamaremos al ViewModel
            // para validar y registrar el plan.
            onClick = {
                // Pendiente de implementación
            },

            modifier = Modifier.fillMaxWidth(),

            // Personalización del color del botón
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF079158)
            )
        ) {

            // Contenido que se muestra dentro del botón
            Text("Crear")
        }
    }
}


/**
 * Vista previa de la pantalla CrearPlanScreen.
 *
 * Permite visualizar el diseño desde Android Studio
 * sin necesidad de ejecutar el emulador.
 */
@Preview(showBackground = true)
@Composable
fun CrearPlanScreenPreview() {
    CrearPlanScreen()
}