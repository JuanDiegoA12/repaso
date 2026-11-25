package com.example.repaso.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.repaso.model.Plan
import com.example.repaso.model.CrearPlanRequest
import com.example.repaso.network.RetrofitClient

// Permite ejecutar corrutinas
import kotlinx.coroutines.launch
import kotlinx.coroutines.CancellationException

// Permite crear estados observables
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Administra los datos y las operaciones
 * relacionadas con los planes de ahorro.
 */
class PlanViewModel : ViewModel() {

    // ==============================
    // ESTADOS
    // ==============================

    // Lista privada que puede modificar el ViewModel
    private val _planes = MutableStateFlow<List<Plan>>(
        emptyList()
    )

    // Lista pública de solo lectura para las pantallas
    val planes = _planes.asStateFlow()


    // Indica si se está realizando una petición
    private val _cargando = MutableStateFlow(false)

    val cargando = _cargando.asStateFlow()


    // Almacena posibles errores de comunicación
    private val _error = MutableStateFlow<String?>(null)

    val error = _error.asStateFlow()


    // ==============================
    // INICIALIZACIÓN
    // ==============================

    init {

        // Se ejecuta al crear el ViewModel
        obtenerPlanes()
    }


    // ==============================
    // OBTENER PLANES
    // ==============================

    /**
     * Consulta todos los planes almacenados
     * en la base de datos mediante Retrofit.
     */
    fun obtenerPlanes() {

        // Ejecutamos una corrutina
        viewModelScope.launch {

            _cargando.value = true
            _error.value = null

            try {

                // Realizamos la petición GET
                val respuesta =
                    RetrofitClient.api.obtenerPlanes()

                // Actualizamos la lista observable
                _planes.value = respuesta

            } catch (e: CancellationException) {

                // Conservamos la cancelación de la corrutina
                throw e

            } catch (e: Exception) {

                // Guardamos el mensaje de error
                _error.value = e.message

            } finally {

                // Finaliza el estado de carga
                _cargando.value = false
            }
        }
    }


    // ==============================
    // CREAR PLAN
    // ==============================

    /**
     * Envía un nuevo plan al backend.
     *
     * @param plan Información del nuevo plan.
     * @param onSuccess Acción ejecutada si se registra.
     */
    fun crearPlan(
        plan: CrearPlanRequest,
        onSuccess: () -> Unit = {}
    ) {

        viewModelScope.launch {

            _cargando.value = true
            _error.value = null

            try {

                // Realizamos la petición POST
                val nuevoPlan =
                    RetrofitClient.api.crearPlan(plan)

                // Agregamos el plan devuelto a la lista
                _planes.value = _planes.value + nuevoPlan

                // Notificamos que el registro fue exitoso
                onSuccess()

            } catch (e: CancellationException) {

                throw e

            } catch (e: Exception) {

                _error.value = e.message

            } finally {

                _cargando.value = false
            }
        }
    }
}