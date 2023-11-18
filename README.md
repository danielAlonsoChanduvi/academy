# ReadMe of Academy APP

## 1. Project description

This project see a simple API project. This project was developed
with *Spring boot 2.7.15* and *Java 11*. It allows us to register and obtain
about data students.

## 2. Functional requirements

- Manage data about of students and their relatives
- A student must have 2 parents
- Any relatives can be a student
- The relatives can be: parents, siblings and spouse
- A family is by 2 relatives
- Queries:
  - Show the relatives of a student
  - Show students by: name, range birthday dates, document number
- Student data:
  - Full name
  - Gender
  - Birthdate
  - Document type
  - Document number


- Cosas que faltan
  - filtro por fecha de nacimiento
  - manejo de excepciones
  - login - authenticate and authorization



- Docker commands
  - docker images
  - docker ps
  - docker ps -a
  - docker run -d nginx:1.25
  - docker run nginx:1.24.0-alpine
  - docker run -d -p 9000:80 nginx:1.25
  - docker logs <idcontainer>
  - docker stop <idcontainer>
  - docker start <idcontainer>
  - docker build -t java-app:1.0 .
  - docker run -d -p 8080:8080 java-app:1.0 .