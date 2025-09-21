package ru.miit.showcase.backend.model

data class Teacher(
    val uuid: String?,
    val revision: Long?,
    val idempotencyToken: String?,
    val firstName: String?,
    val lastName: String?,
    val patronymic: String?
)
