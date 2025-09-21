package ru.miit.showcase.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShowcaseBackendApplication

fun main(args: Array<String>) {
    runApplication<ShowcaseBackendApplication>(*args)
}
