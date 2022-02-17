## Домашнее задание по курсу Otus ["Microservice Architecture"](https://otus.ru/lessons/microservice-architecture/?int_source=courses_catalog&int_term=programming)

### Установка db postgres
``` shell script
helm repo add bitnami https://charts.bitnami.com/bitnami
```
``` shell script
helm install pg-release bitnami/postgresql
```
init db script: *\data\dbinit.sql*

*Read more about the installation in the [PostgreSQL packaged by Bitnami Chart Github repository](https://github.com/bitnami/charts/tree/master/bitnami/postgresql/#installing-the-chart)*

### Манифесты k8s
#### Job для миграции БД
- *\k8s\host-pv.yaml*
- *\k8s\host-pvc.yaml*
- *\k8s\pg-job.yaml*
#### Приложение
- *\k8s\app-env-config.yaml*
- *\k8s\app-spec-config.yaml*
- *\k8s\app-deployment.yaml*
- *\k8s\app-service.yaml*
- *\k8s\app-ingress.yaml*
- *\k8s\app-egress.yaml*


### Коллекция postman
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/8684620-ba32462f-a795-4ba2-b9bd-8cbc4e8a3d00?action=collection%2Ffork&collection-url=entityId%3D8684620-ba32462f-a795-4ba2-b9bd-8cbc4e8a3d00%26entityType%3Dcollection%26workspaceId%3D1c9635ea-c5e7-4ae3-ab6d-7fe223a5b93c)

["Microservice Architecture"]:(https://otus.ru/lessons/microservice-architecture/?int_source=courses_catalog&int_term=programming)
[PostgreSQL packaged by Bitnami Chart Github repository]:(https://github.com/bitnami/charts/tree/master/bitnami/postgresql/#installing-the-chart)
