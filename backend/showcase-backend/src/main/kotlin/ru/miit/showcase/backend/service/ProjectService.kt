package ru.miit.showcase.backend.service

import jooq.tables.records.CustomerRecord
import jooq.tables.records.ProjectRecord
import jooq.tables.references.CUSTOMER
import jooq.tables.references.PROJECT
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import ru.miit.showcase.backend.model.Customer
import ru.miit.showcase.backend.model.Project

@Service
class ProjectService(
    private val jooq: DSLContext
) {
    fun getAllProjects(limit: Int = 25): List<Project> =
        jooq
            .select(PROJECT.asterisk(), CUSTOMER.asterisk())
            .from(PROJECT)
            .leftJoin(CUSTOMER).on(PROJECT.CUSTOMER_ID.eq(CUSTOMER.UUID))
            .limit(limit)
            //.offset(offset)
            .fetch { record ->
                val projectRec: ProjectRecord = record.into(PROJECT)
                val customerRec: CustomerRecord = record.into(CUSTOMER)
                projectRec.toDomain(customerRec)
            }
}

private fun ProjectRecord.toDomain(customerRecord: CustomerRecord) = Project(
    uuid = uuid,
    revision = revision?.toLong(),
    title = title,
    customer = customerRecord.toDomain(),
    goal = goal,
    projectBarrier = projectBarrier,
    alternativeSolutions = alternativeSolutions,
    projectType = projectType,
    institute = institute,
    department = department,
    addedBy = addedBy,
    addedDate = addedDate,
    updatedDate = updatedDate,
    deletedDate = deletedDate
)

private fun CustomerRecord.toDomain() = Customer(
    uuid = uuid,
    revision = revision?.toLong(),
    idempotencyToken = idempotencytoken,
    firstName = firstname,
    lastName = lastname,
    patronymic = patronymic
)