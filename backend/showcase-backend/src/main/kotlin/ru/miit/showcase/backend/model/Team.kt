package ru.miit.showcase.backend.model

import java.time.LocalDate

data class Team(
    val uuid: String?,
    val revision: Long?,
    val idempotencyToken: String?,
    val teacher: Teacher?,
    val students: List<Student>?,
    val organizationDate: LocalDate?,
)