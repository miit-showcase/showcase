package ru.miit.showcase.backend.model

data class Student(
    val uuid: String,
    val revision: Long,
    val idempotencyToken: String,
    val projectTeachers: Teacher,
    val studyGroup: StudyGroup,
    val firstName: String,
    val lastName: String,
    val patronymic: String?,
    val teamId: String?,
)