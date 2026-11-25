package com.example.repaso.model

/**
 * Representa los datos enviados al servidor
 * para registrar un nuevo plan de ahorro.
 *
 * No incluye id ni createdAt porque son
 * generados automáticamente por SQLite.
 */
data class CrearPlanRequest(
    val name: String,
    val motive: String?,
    val targetAmount: Double,
    val months: Int
)
