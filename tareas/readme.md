# Tareas

to-do list app

[Requerimientos](#requerimientos)

[Contenedor](#contenedor)

## Requerimientos

- NetBeans
- java
  - ant
  - mysql-conector
  - mvc
- mysql
- docker

## Contenedor

- mysql 8.0

1. ```console
    docker pull mysql:8.0
   ```
2. ```console
    docker create --name tarea -p3306:3306
   ```
3. ```console
    docker start tarea
   ```
