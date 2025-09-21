package ru.miit.showcase.backend.model

data class Customer(
    val uuid: String? = null,
    val revision: Long? = null,
    val idempotencyToken: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val patronymic: String? = null,
)