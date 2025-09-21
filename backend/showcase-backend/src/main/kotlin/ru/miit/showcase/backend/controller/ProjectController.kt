package ru.miit.showcase.backend.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.miit.showcase.backend.model.Project
import ru.miit.showcase.backend.service.ProjectService

@RestController
@RequestMapping("/api/v1/projects")
class ProjectController(
    private val projectService: ProjectService
){

    @GetMapping
    fun getProjects(): ResponseEntity<List<Project>> {
        val projects = projectService.getAllProjects()

        if (projects.isEmpty()) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }

        return ResponseEntity(projects, HttpStatus.OK)
    }
}