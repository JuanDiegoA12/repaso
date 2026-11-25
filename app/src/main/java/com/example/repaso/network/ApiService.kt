package com.example.repaso.network

import com.example.repaso.model.Plan
import com.example.repaso.model.CrearPlanRequest

// Anotaciones para definir peticiones HTTP
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Path

/**
 * Interfaz que define los endpoints disponibles
 * en nuestro servidor Node.js.
 *
 * Retrofit genera automáticamente su implementación.
 */
interface ApiService {

    /**
     * Obtiene todos los planes registrados.
     *
     * GET /api/plans
     *
     * @return Lista de planes de ahorro.
     */
    @GET("api/plans")
    suspend fun obtenerPlanes(): List<Plan>


    /**
     * Registra un nuevo plan de ahorro.
     *
     * POST /api/plans
     *
     * @param plan Datos enviados en formato JSON.
     * @return Plan registrado por el servidor.
     */
    @POST("api/plans")
    suspend fun crearPlan(
        @Body plan: CrearPlanRequest
    ): Plan


    /**
     * Obtiene un plan mediante su identificador.
     *
     * GET /api/plans/{id}
     *
     * @param id Identificador del plan.
     * @return Plan encontrado.
     */
    @GET("api/plans/{id}")
    suspend fun obtenerPlanPorId(
        @Path("id") id: Int
    ): Plan
}