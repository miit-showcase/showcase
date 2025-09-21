package ru.miit.showcase.backend.model

import java.time.LocalDate

data class Project(
    val uuid: String? = null,
    val revision: Long? = null,
    val title: String? = null,
    val customer: Customer? = null,
    val goal: String? = null,
    val projectBarrier: String? = null,
    val alternativeSolutions: String? = null,
    val projectType: String? = null,
    val institute: String? = null,
    val department: String? = null,
    val addedBy: String? = null,
    val addedDate: LocalDate? = null,
    val updatedDate: LocalDate? = null,
    val deletedDate: LocalDate? = null,
)