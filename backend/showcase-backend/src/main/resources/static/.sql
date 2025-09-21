CREATE TABLE project (
                         uuid VARCHAR(255) PRIMARY KEY,
                         revision INT,
                         customer_id VARCHAR(255),
                         title VARCHAR(255),
                         goal TEXT,
                         project_barrier TEXT,
                         alternative_solutions TEXT,
                         project_type VARCHAR(255),
                         institute VARCHAR(255),
                         department VARCHAR(255),
                         added_by VARCHAR(255),
                         added_date DATE,
                         updated_date DATE,
                         deleted_date DATE
);

CREATE TABLE student (
                         uuid VARCHAR(255) PRIMARY KEY,
                         revision INT,
                         idempotency_token VARCHAR(255),
                         project_teacher VARCHAR(255),
                         study_group VARCHAR(255),
                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         patronymic VARCHAR(255),
                         team_id VARCHAR(255),
                         FOREIGN KEY (team_id) REFERENCES team(uuid)
);

CREATE TABLE teacher (
                         uuid VARCHAR(255) PRIMARY KEY,
                         revision INT,
                         idempotency_token VARCHAR(255),
                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         patronymic VARCHAR(255)
);

CREATE TABLE team (
                      uuid VARCHAR(255) PRIMARY KEY,
                      idempotency_token VARCHAR(255),
                      teacher VARCHAR(255),
                      organization_date DATE,
                      revision INT,
                      FOREIGN KEY (teacher) REFERENCES teacher(uuid)
);

CREATE TABLE project_progress (
                                  uuid VARCHAR(255) PRIMARY KEY,
                                  team_id VARCHAR(255),
                                  project_id VARCHAR(255),
                                  revision INT,
                                  status VARCHAR(255),
                                  expiry_date DATE,
                                  state VARCHAR(255),
                                  FOREIGN KEY (team_id) REFERENCES team(uuid),
                                  FOREIGN KEY (project_id) REFERENCES project(uuid)
);

CREATE TABLE project_keywords (
                                  id INT PRIMARY KEY,
                                  project_id VARCHAR(255),
                                  keyword VARCHAR(255),
                                  FOREIGN KEY (project_id) REFERENCES project(uuid)
);

CREATE TABLE project_scope (
                               id INT PRIMARY KEY,
                               project_id VARCHAR(255),
                               scope VARCHAR(255),
                               FOREIGN KEY (project_id) REFERENCES project(uuid)
);

CREATE TABLE project_request (
                                 uuid VARCHAR(255) PRIMARY KEY,
                                 project_id VARCHAR(255),
                                 idempotency_token VARCHAR(255),
                                 team_id VARCHAR(255),
                                 date DATE,
                                 FOREIGN KEY (project_id) REFERENCES project(uuid),
                                 FOREIGN KEY (team_id) REFERENCES team(uuid)
);
