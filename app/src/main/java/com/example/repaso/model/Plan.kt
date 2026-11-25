package com.example.repaso.model

/**
 * Representa un plan de ahorro recibido desde el backend.
 *
 * Los nombres de los atributos coinciden con las
 * propiedades del JSON enviado por Node.js.
 *
 * @param id Identificador del plan en SQLite.
 * @param name Nombre del plan de ahorro.
 * @param motive Motivo del ahorro.
 * @param targetAmount Cantidad de dinero objetivo.
 * @param months Duración del plan en meses.
 * @param createdAt Fecha de creación del plan.
 */
data class Plan(
    val id: Int,
    val name: String,
    val motive: String?,
    val targetAmount: Double,
    val months: Int,
    val createdAt: String
)