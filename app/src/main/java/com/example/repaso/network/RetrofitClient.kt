package com.example.repaso.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Configura la conexión entre Android
 * y nuestro servidor Node.js.
 *
 * object permite tener una única instancia
 * de este componente en la aplicación.
 */
object RetrofitClient {

    // Dirección del servidor desde el emulador Android
    private const val BASE_URL = "http://10.0.2.2:3000/"

    /**
     * Construye la instancia de Retrofit.
     */
    private val retrofit = Retrofit.Builder()

        // Dirección principal del servidor
        .baseUrl(BASE_URL)

        // Convierte automáticamente objetos y JSON
        .addConverterFactory(
            GsonConverterFactory.create()
        )

        // Finaliza la construcción de Retrofit
        .build()

    /**
     * Genera la implementación de nuestra interfaz.
     *
     * Mediante api podremos ejecutar las peticiones
     * definidas en ApiService.
     */
    val api: ApiService = retrofit.create(
        ApiService::class.java
    )
}